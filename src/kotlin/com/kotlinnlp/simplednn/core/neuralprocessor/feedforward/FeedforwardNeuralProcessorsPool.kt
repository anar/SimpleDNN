package com.kotlinnlp.simplednn.core.neuralprocessor.feedforward

import com.kotlinnlp.simplednn.core.neuralnetwork.NeuralNetwork
import com.kotlinnlp.simplednn.core.neuralprocessor.NeuralProcessor
import com.kotlinnlp.simplednn.core.neuralprocessor.NeuralProcessorsPool
import com.kotlinnlp.simplednn.simplemath.ndarray.NDArray

/**
 * A pool of [NeuralProcessor]s which allows to allocate and release processors when needed, without creating a new one.
 * It is useful to optimize the creation of new structures every time a processor is created.
 *
 * @property neuralNetwork the [NeuralNetwork] which the processors of the pool will work with
 */
class FeedforwardNeuralProcessorsPool<InputNDArrayType : NDArray<InputNDArrayType>>(
  val neuralNetwork: NeuralNetwork
) : NeuralProcessorsPool<FeedforwardNeuralProcessor<InputNDArrayType>>(neuralNetwork) {

  /**
   * The factory of a new processor
   *
   * @param id the id of the processor to create
   *
   * @return a new [FeedforwardNeuralProcessor] with the given [id]
   */
  override fun processorFactory(id: Int) = FeedforwardNeuralProcessor<InputNDArrayType>(
    neuralNetwork = this.neuralNetwork,
    id = id
  )
}
