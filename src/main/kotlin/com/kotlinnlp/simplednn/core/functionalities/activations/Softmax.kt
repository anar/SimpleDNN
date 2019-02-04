/* Copyright 2016-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, you can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.simplednn.core.functionalities.activations

import com.kotlinnlp.simplednn.simplemath.ndarray.Shape
import com.kotlinnlp.simplednn.simplemath.ndarray.dense.DenseNDArray
import com.kotlinnlp.simplednn.simplemath.ndarray.dense.DenseNDArrayFactory

/**
 * The softmax function transforms a vector in non-negative real numbers that
 * lie between zero and one and sum to one.
 * Its output is interpretable as a discrete probability distribution over k possible outcomes.
 *
 */
class Softmax : ActivationFunction {

  /**
   * Assign to [out] the result of the Softmax function calculated respect to the input array.
   *
   * @param array the input array
   * @param out the NDArray in which the result is written
   */
  override fun f(array: DenseNDArray, out: DenseNDArray) {

    val max: Double = array[array.argMaxIndex()]
    var sum = 0.0

    for (i in 0 until array.length) {
      val e: Double = Math.exp(array[i] - max)
      out[i] = e
      sum += e
    }

    out.assignDiv(sum)
  }

  /**
   * Calculate the Softmax derivative respect to the input array.
   *
   * @param xArray the input array
   *
   * @return a new NDArray containing the result (the Jacobian matrix)
   */
  override fun df(xArray: DenseNDArray): DenseNDArray {

    val jacobianMatrix: DenseNDArray = DenseNDArrayFactory.zeros(shape = Shape(xArray.length, xArray.length))

    for (i in 0 until xArray.length) {
      for (j in i until xArray.length) {

        jacobianMatrix[i, j] = if (i == j) xArray[i] * (1.0 - xArray[j]) else - xArray[i] * xArray[j]

        if (i != j) {
          jacobianMatrix[j, i] = jacobianMatrix[i, j]
        }
      }
    }

    return jacobianMatrix
  }

  /**
   * Calculate the Softmax derivative respect to the input array already activated, as optimization.
   *
   * @param fxArray the input array already activated
   *
   * @return a new NDArray containing the result
   */
  override fun dfOptimized(fxArray: DenseNDArray): DenseNDArray = DenseNDArrayFactory.ones(fxArray.shape)

  /**
   * Assign to [out] the Softmax derivative calculated respect to the input array already activated, as optimization.
   *
   * @param fxArray the input array already activated
   * @param out the NDArray in which the result is written
   */
  override fun dfOptimized(fxArray: DenseNDArray, out: DenseNDArray) {
    out.ones()
  }
}
