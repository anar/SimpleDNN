/* Copyright 2016-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, you can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package com.kotlinnlp.simplednn.deeplearning.embeddings

/**
 * A container of Embeddings mapped to Int ids.
 *
 * @property count the number of embeddings in this [EmbeddingsContainer] (e.g. number of word in a vocabulary)
 * @property size the size of each embedding (typically a range between about 50 to a few hundreds)
 */
class EmbeddingsContainer(
  count: Int,
  size: Int
) : EmbeddingsContainerBase<EmbeddingsContainer>(
  count = count,
  size = size)
