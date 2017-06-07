/* Copyright 2016-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, you can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.simplednn.core.neuralprocessor.recurrent

import com.kotlinnlp.simplednn.core.optimizer.ParamsErrorsAccumulator
import com.kotlinnlp.simplednn.core.neuralnetwork.NetworkParameters
import com.kotlinnlp.simplednn.core.neuralnetwork.NeuralNetwork
import com.kotlinnlp.simplednn.core.neuralnetwork.structure.recurrent.RecurrentNetworkStructure
import com.kotlinnlp.simplednn.core.neuralnetwork.structure.recurrent.StructureContextWindow
import com.kotlinnlp.simplednn.core.neuralprocessor.NeuralProcessor
import com.kotlinnlp.simplednn.simplemath.ndarray.dense.DenseNDArray
import com.kotlinnlp.simplednn.simplemath.ndarray.dense.DenseNDArrayFactory
import com.kotlinnlp.simplednn.simplemath.ndarray.NDArray
import com.kotlinnlp.simplednn.simplemath.ndarray.Shape

/**
 * The [RecurrentNeuralProcessor] acts on the [neuralNetwork] performing predictions
 * and training based on sequences of recurrent Examples.
 *
 * @property neuralNetwork a [NeuralNetwork]
 */
class RecurrentNeuralProcessor<InputNDArrayType : NDArray<InputNDArrayType>>(
  neuralNetwork: NeuralNetwork
) : StructureContextWindow<InputNDArrayType>,
    NeuralProcessor(neuralNetwork) {

  /**
   * sequence
   */
  private val sequence = NNSequence<InputNDArrayType>(neuralNetwork)

  /**
   * Set each time a single forward or a single backward are called
   */
  private var curStateIndex: Int = 0

  /**
   * The errors of the network model parameters calculated during a single backward
   */
  private var backwardParamsErrors: NetworkParameters = this.neuralNetwork.parametersErrorsFactory()

  /**
   *
   */
  private var paramsErrorsAccumulator: ParamsErrorsAccumulator = ParamsErrorsAccumulator(neuralNetwork)

  /**
   *
   */
  private val zeroErrors: DenseNDArray = DenseNDArrayFactory.zeros(
    Shape(this.neuralNetwork.layersConfiguration.last().size)
  )

  /**
   *
   */
  override fun getPrevStateStructure(): RecurrentNetworkStructure<InputNDArrayType>? {
    return this.sequence.getStateStructure(this.curStateIndex - 1)
  }

  /**
   *
   */
  override fun getNextStateStructure(): RecurrentNetworkStructure<InputNDArrayType>? {
    return this.sequence.getStateStructure(this.curStateIndex + 1)
  }

  /**
   *
   */
  override fun getParamsErrors(copy: Boolean): NetworkParameters {

    val paramsError: NetworkParameters

    if (copy) {
      paramsError = this.neuralNetwork.parametersErrorsFactory()
      paramsError.assignValues(this.paramsErrorsAccumulator.getParamsErrors())

    } else {
      paramsError = this.paramsErrorsAccumulator.getParamsErrors()
    }

    return paramsError
  }

  /**
   *
   */
  override fun getOutput(copy: Boolean): DenseNDArray {
    return if (copy) {
      this.sequence.lastStructure!!.outputLayer.outputArray.values.copy()
    } else {
      this.sequence.lastStructure!!.outputLayer.outputArray.values
    }
  }

  /**
   *
   */
  private fun addNewState() {

    val structure = RecurrentNetworkStructure(
      layersConfiguration = this.neuralNetwork.layersConfiguration,
      params = this.neuralNetwork.model,
      structureContextWindow = this)

    this.sequence.add(structure)

    this.curStateIndex = this.sequence.lastIndex
  }

  /**
   * Forward the current state.
   *
   * @param featuresArray the features to forward from the input to the output
   * @param useDropout whether to apply the dropout
   */
  private fun forwardCurrentState(featuresArray: InputNDArrayType, useDropout: Boolean = false) {
    this.sequence.lastStructure!!.forward(features = featuresArray, useDropout = useDropout)
  }

  /**
   * Reset the sequence.
   */
  private fun reset() {
    this.sequence.reset()
    this.paramsErrorsAccumulator.reset()
  }

  /**
   *
   */
  fun getInputSequenceErrors(copy: Boolean = true) = Array(
    size = this.sequence.length,
    init = {
      val inputErrors = this.sequence.states[it].structure.inputLayer.inputArray.errors

      require(inputErrors is DenseNDArray) {
        "Input errors available only if input is dense"
      }

      if (copy) {
        inputErrors.copy()
      } else {
        inputErrors
      }
    }
  )

  /**
   *
   */
  fun getOutputSequence(copy: Boolean = true): Array<DenseNDArray> =
    Array(size = this.sequence.length, init = {
      if (copy) {
        this.sequence.states[it].structure.outputLayer.outputArray.values.copy()
      } else {
        this.sequence.states[it].structure.outputLayer.outputArray.values
      }
    })

  /**
   * Forward a sequence.
   *
   * @param sequenceFeaturesArray the features to forward for each item of the sequence
   * @param useDropout whether to apply the dropout
   *
   * @return the last output of the network after the whole sequence is been forwarded
   */
  fun forward(sequenceFeaturesArray: ArrayList<InputNDArrayType>, useDropout: Boolean = false): DenseNDArray {

    sequenceFeaturesArray.forEachIndexed { i, features ->
      this.forward(featuresArray = features, firstState = (i == 0), useDropout = useDropout)
    }

    return this.getOutput()
  }

  /**
   * Forward features.
   *
   * @param featuresArray the features to forward from the input to the output
   * @param useDropout whether to apply the dropout
   */
  fun forward(featuresArray: InputNDArrayType, firstState: Boolean, useDropout: Boolean = false): DenseNDArray {

    if (firstState) {
      this.reset()
    }

    this.addNewState()
    this.forwardCurrentState(featuresArray = featuresArray, useDropout = useDropout)

    return this.getOutput()
  }

  /**
   *
   * @param outputErrors output error
   */
  fun backward(outputErrors: DenseNDArray, propagateToInput: Boolean = false) {

    val outputErrorsSequence = Array(
      size = this.sequence.length,
      init = {i -> if (sequence.isLast(i)) outputErrors else this.zeroErrors})

    this.backward(outputErrorsSequence = outputErrorsSequence, propagateToInput = propagateToInput)
  }

  /**
   *
   * @param outputErrorsSequence output errors for each item of the sequence
   */
  fun backward(outputErrorsSequence: Array<DenseNDArray>, propagateToInput: Boolean = false) {

    require(outputErrorsSequence.size == this.sequence.length) {
      "Number of errors (${outputErrorsSequence.size}) does not " +
        "reflect the length of the sequence (${this.sequence.length})"
    }

    for ((i, state) in this.sequence.states.withIndex().reversed()) {

      this.curStateIndex = i // crucial to provide the right context

      state.structure.backward(
        outputErrors = outputErrorsSequence[i],
        paramsErrors = this.backwardParamsErrors,
        propagateToInput = propagateToInput)

      this.paramsErrorsAccumulator.accumulate(this.backwardParamsErrors)
    }

    this.paramsErrorsAccumulator.averageErrors()
  }

}
