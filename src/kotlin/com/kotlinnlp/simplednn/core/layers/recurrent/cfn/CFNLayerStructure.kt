/* Copyright 2016-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, you can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.simplednn.core.layers.recurrent.cfn

import com.kotlinnlp.simplednn.core.arrays.AugmentedArray
import com.kotlinnlp.simplednn.core.arrays.DistributionArray
import com.kotlinnlp.simplednn.core.functionalities.activations.ActivationFunction
import com.kotlinnlp.simplednn.core.functionalities.activations.Sigmoid
import com.kotlinnlp.simplednn.core.layers.*
import com.kotlinnlp.simplednn.core.layers.recurrent.*
import com.kotlinnlp.simplednn.simplemath.ndarray.dense.DenseNDArray
import com.kotlinnlp.simplednn.simplemath.ndarray.dense.DenseNDArrayFactory
import com.kotlinnlp.simplednn.simplemath.ndarray.NDArray
import com.kotlinnlp.simplednn.simplemath.ndarray.Shape

/**
 * The CFN Layer Structure.
 *
 * @property inputArray the input array of the layer
 * @property outputArray the output array of the layer
 * @property params the parameters which connect the input to the output
 * @property layerContextWindow the context window used for the forward and the backward
 * @property activationFunction the activation function of the layer
 * @property dropout the probability of dropout (default 0.0).
 *                   If applying it, the usual value is 0.5 (better 0.25 if it's the first layer).
 */
class CFNLayerStructure<InputNDArrayType : NDArray<InputNDArrayType>>(
  inputArray: AugmentedArray<InputNDArrayType>,
  outputArray: AugmentedArray<DenseNDArray>,
  params: LayerParameters,
  layerContextWindow: LayerContextWindow,
  activationFunction: ActivationFunction? = null,
  dropout: Double = 0.0
) : RecurrentLayerStructure<InputNDArrayType>(
  inputArray = inputArray,
  outputArray = outputArray,
  params = params,
  layerContextWindow = layerContextWindow,
  activationFunction = activationFunction,
  dropout = dropout) {

  /**
   * A support variable to manage the errors on the parameters during the backward
   */
  var paramsErrors: CFNLayerParameters? = null

  /**
   *
   */
  val candidate = AugmentedArray<DenseNDArray>(values = DenseNDArrayFactory.emptyArray(Shape(outputArray.size)))

  /**
   *
   */
  val inputGate = GateUnit<InputNDArrayType>(outputArray.size)

  /**
   *
   */
  val forgetGate = GateUnit<InputNDArrayType>(outputArray.size)

  /**
   *
   */
  var activatedPrevOutput: DenseNDArray? = null

  /**
   * Initialization: set the activation function of the gates
   */
  init {

    this.inputGate.setActivation(Sigmoid())
    this.forgetGate.setActivation(Sigmoid())

    if (this.activationFunction != null) {
      this.candidate.setActivation(this.activationFunction)
    }
  }

  /**
   * y = inG * c + f(yPrev) * forG
   */
  override fun forwardInput() {

    val prevStateLayer = this.layerContextWindow.getPrevStateLayer()

    this.setGates(prevStateLayer) // must be called before accessing to the activated values of the gates

    val y: DenseNDArray = this.outputArray.values
    val c: DenseNDArray = this.candidate.values
    val inG: DenseNDArray = this.inputGate.values
    val forG: DenseNDArray = this.forgetGate.values

    // y = inG * c
    y.assignProd(inG, c)

    // y += f(yPrev) * forG
    if (prevStateLayer != null) {
      val yPrev = prevStateLayer.outputArray.values
      this.activatedPrevOutput = if (this.activationFunction != null) this.activationFunction.f(yPrev) else yPrev

      y.assignSum(this.activatedPrevOutput!!.prod(forG))
    }
  }

  /**
   * Forward the input to the output combining it with the parameters, saving the contributes of the parameters.
   *
   * @param paramsContributes the [LayerParameters] in which to save the contributes of the parameters
   */
  override fun forwardInput(paramsContributes: LayerParameters) {
    TODO("not implemented")
  }

  /**
   * Calculate the relevance of the input.
   *
   * @param paramsContributes the contributes of the parameters during the last forward
   * @param relevantOutcomesDistribution the distribution which indicates which outcomes are relevant, used
   *                                     as reference to calculate the relevance of the input
   */
  override fun calculateRelevance(paramsContributes: LayerParameters,
                                  relevantOutcomesDistribution: DistributionArray) {
    TODO("not implemented")
  }


  /**
   * Set gates values
   *
   * inG = sigmoid(wIn (dot) x + bIn + wrIn (dot) yPrev)
   * forG = sigmoid(wForG (dot) x + bForG + wrForG (dot) yPrev)
   * c = f(wc (dot) x)
   */
  private fun setGates(prevStateLayer: LayerStructure<*>?) { this.params as CFNLayerParameters

    val x: InputNDArrayType = this.inputArray.values
    val c: DenseNDArray = this.candidate.values
    val wc: DenseNDArray = this.params.candidateWeights.values as DenseNDArray

    this.inputGate.forward(this.params.inputGate, x)
    this.forgetGate.forward(this.params.forgetGate, x)
    c.assignDot(wc, x)

    if (prevStateLayer != null) { // recurrent contribute for input and forget gates
      val yPrev = prevStateLayer.outputArray.values
      this.inputGate.addRecurrentContribute(this.params.inputGate, yPrev)
      this.forgetGate.addRecurrentContribute(this.params.forgetGate, yPrev)
    }

    this.inputGate.activate()
    this.forgetGate.activate()
    this.candidate.activate()
  }

  /**
   *
   */
  override fun backward(paramsErrors: LayerParameters, propagateToInput: Boolean) {

    this.paramsErrors = paramsErrors as CFNLayerParameters

    val prevStateLayer = this.layerContextWindow.getPrevStateLayer() as? CFNLayerStructure
    val nextStateLayer = this.layerContextWindow.getNextStateLayer() as? CFNLayerStructure

    this.addOutputRecurrentGradients(nextStateLayer)

    this.assignGatesGradients(prevStateLayer)
    this.assignParamsGradients(prevStateLayer?.outputArray)

    if (propagateToInput) {
      this.assignLayerGradients()
    }
  }

  /**
   *
   * @param prevStateLayer the layer in the previous state
   */
  private fun assignGatesGradients(prevStateLayer: CFNLayerStructure<*>?) {
    this.params as CFNLayerParameters

    val gy: DenseNDArray = this.outputArray.errors

    val inputGate = this.inputGate
    val forgetGate = this.forgetGate
    val candidate = this.candidate

    val ingG: DenseNDArray = inputGate.values
    val c: DenseNDArray = candidate.values

    val inGDeriv: DenseNDArray = inputGate.calculateActivationDeriv()
    val cDeriv: DenseNDArray = candidate.calculateActivationDeriv()

    val gInG: DenseNDArray = this.inputGate.errors
    val gc: DenseNDArray = this.candidate.errors

    gInG.assignProd(c, inGDeriv).assignProd(gy)
    gc.assignProd(ingG, cDeriv).assignProd(gy)

    if (prevStateLayer != null) {
      val aPrev: DenseNDArray = this.activatedPrevOutput!!
      val forGDeriv: DenseNDArray = forgetGate.calculateActivationDeriv()
      val gForG: DenseNDArray = this.forgetGate.errors

      gForG.assignProd(aPrev, forGDeriv).assignProd(gy)
    }
  }

  /**
   *
   * @param prevStateOutput the outputArray in the previous state
   */
  private fun assignParamsGradients(prevStateOutput: AugmentedArray<DenseNDArray>?) {

    val x: InputNDArrayType = this.inputArray.values
    val yPrev: DenseNDArray? = prevStateOutput?.values

    this.inputGate.assignParamsGradients(paramsErrors = this.paramsErrors!!.inputGate, x = x, yPrev = yPrev)
    this.forgetGate.assignParamsGradients(paramsErrors = this.paramsErrors!!.forgetGate, x = x, yPrev = yPrev)

    val gc: DenseNDArray = this.candidate.errors
    val gwc: NDArray<*> = this.paramsErrors!!.candidateWeights.values
    gwc.assignDot(gc, x.T)
  }

  /**
   *
   */
  private fun assignLayerGradients() { this.params as CFNLayerParameters

    val gx: DenseNDArray = this.inputArray.errors

    val wInG: DenseNDArray = this.params.inputGate.weights.values as DenseNDArray
    val wForG: DenseNDArray = this.params.forgetGate.weights.values as DenseNDArray
    val wC: DenseNDArray = this.params.candidateWeights.values as DenseNDArray

    val gInG: DenseNDArray = this.inputGate.errors
    val gForG: DenseNDArray = this.forgetGate.errors
    val gC: DenseNDArray = this.candidate.errors

    gx.assignValues(gForG.T.dot(wForG)).assignSum(gC.T.dot(wC)).assignSum(gInG.T.dot(wInG))

    if (this.inputArray.hasActivation && gx is DenseNDArray) {
      gx.assignProd(this.inputArray.calculateActivationDeriv())
    }
  }

  /**
   *
   * @param nextStateLayer the layer structure in the next state
   */
  private fun addOutputRecurrentGradients(nextStateLayer: CFNLayerStructure<*>?) {

    if (nextStateLayer != null) {
      val gy: DenseNDArray = this.outputArray.errors
      val gyRec: DenseNDArray = this.getLayerRecurrentContribute(nextStateLayer)

      gy.assignSum(gyRec)
    }
  }

  /**
   *
   * @param nextStateLayer the layer structure in the next state
   */
  private fun getLayerRecurrentContribute(nextStateLayer: CFNLayerStructure<*>): DenseNDArray {
    this.params as CFNLayerParameters

    val inputGate = nextStateLayer.inputGate
    val forgetGate = nextStateLayer.forgetGate

    val gyNext: DenseNDArray = nextStateLayer.outputArray.errors

    val yDeriv: DenseNDArray = if (nextStateLayer.activationFunction != null)
      nextStateLayer.activationFunction.dfOptimized(nextStateLayer.activatedPrevOutput!!)
    else
      nextStateLayer.activatedPrevOutput!!

    val forG: DenseNDArray = forgetGate.values

    val gInG: DenseNDArray = inputGate.errors
    val gForG: DenseNDArray = forgetGate.errors

    val wrInG: DenseNDArray = this.params.inputGate.recurrentWeights.values
    val wrForG: DenseNDArray = this.params.forgetGate.recurrentWeights.values

    val gRec1: DenseNDArray = forG.prod(yDeriv).assignProd(gyNext)
    val gRec2: DenseNDArray = gInG.T.dot(wrInG)
    val gRec3: DenseNDArray = gForG.T.dot(wrForG)

    return gRec1.assignSum(gRec2).assignSum(gRec3)
  }
}
