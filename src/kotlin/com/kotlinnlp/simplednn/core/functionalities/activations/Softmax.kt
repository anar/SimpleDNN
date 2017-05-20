/* Copyright 2016-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, you can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.simplednn.core.functionalities.activations

import com.kotlinnlp.simplednn.simplemath.*

/**
 * The softmax function transforms a vector in non-negative real numbers that
 * lie between zero and one and sum to one.
 * Its output is interpretable as a discrete probability distribution over k possible outcomes.
 *
 */
class Softmax : ActivationFunction {

  /**
   * Assign to [out] the result of Softmax function applied to [array].
   *
   * @param array the input NDArray
   * @param out the NDArray in which the result is written
   */
  override fun f(array: NDArray, out: NDArray) {

    val max: Double = array[array.argMaxIndex()].toDouble()
    var sum: Double = 0.0

    for (i in 0 until array.length) {
      val e: Double = Math.exp(array[i].toDouble() - max)
      out[i] = e
      sum += e
    }

    out.assignDiv(sum)
  }

  /**
   * Apply the Softmax function derivative to [fxArray].
   *
   * @param fxArray the input NDArray (WARNING: it must be f(x) for optimization)
   *
   * @return a new NDArray containing the result
   */
  override fun dfOptimized(fxArray: NDArray): NDArray = fxArray.copy()

  /**
   * Assign to [out] the Softmax function derivative calculated in [fxArray].
   *
   * @param fxArray the input NDArray (WARNING: it must be f(x) for optimization)
   * @param out the NDArray in which the result is written
   */
  override fun dfOptimized(fxArray: NDArray, out: NDArray) {
    out.assignValues(fxArray)
  }
}
