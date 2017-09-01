/* Copyright 2016-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, you can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.simplednn.deeplearning.mergelayers.affine

import com.kotlinnlp.simplednn.core.layers.ForwardHelper
import com.kotlinnlp.simplednn.core.layers.LayerParameters
import com.kotlinnlp.simplednn.simplemath.ndarray.NDArray

/**
 * The helper which executes the forward on an affine [layer].
 *
 * @property layer the [AffineLayerStructure] in which the forward is executed
 */
class AffineForwardHelper<InputNDArrayType : NDArray<InputNDArrayType>>(
  override val layer: AffineLayerStructure<InputNDArrayType>
) : ForwardHelper<InputNDArrayType>(layer) {

  /**
   * Forward the input to the output combining it with the parameters.
   *
   * y = f(w1 (dot) x1 + w2 (dot) x2 + b)
   */
  override fun forward() { this.layer.params as AffineLayerParameters

    TODO("not implemented")

//    this.layer.outputArray.activate()
  }

  /**
   * Forward the input to the output combining it with the parameters, saving the contributions.
   *
   * y = f(w1 (dot) x1 + w2 (dot) x2 + b)
   *
   * @param layerContributions the structure in which to save the contributions during the calculations
   */
  override fun forward(layerContributions: LayerParameters) {
    this.layer.params as AffineLayerParameters
    layerContributions as AffineLayerParameters

    TODO("not implemented")
  }
}
