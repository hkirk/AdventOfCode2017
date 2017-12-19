package org.busywait.d3

/*
  Memory allocated in a spiral outward from 1
    17  16  15  14  13
    18   5   4   3  12
    19   6   1   2  11
    20   7   8   9  10
    21  22  23---> ...
 */
class SpiralMemory(square: Long) {
  private val squaredCeil = Math.ceil(Math.sqrt(square)).asInstanceOf[Long]
  private val squared = if (squaredCeil % 2 == 0) squaredCeil + 1 else squaredCeil
  private val squaredHalf = Math.floor(squared.asInstanceOf[Double] / 2).asInstanceOf[Long]
  // Location of 1
  private val center = (squaredHalf, squaredHalf)
  private val highestNum = Math.pow(squared, 2).asInstanceOf[Long]

  private def locationOfSquare(): (Long, Long) = {
    val cornerBottomRight = highestNum
    val cornerBottomLeft = highestNum - squared+1
    val cornerTopLeft = cornerBottomLeft - squared+1
    val cornerTopRight = cornerTopLeft - squared+1

    if (cornerBottomLeft < square) (squared-1, highestNum - square)
    else if (cornerTopLeft < square) (0L, cornerBottomLeft - square)
    else if (cornerTopRight < square) (0L, cornerTopLeft - square)
    else (squared-1, cornerTopRight - square)
  }

  private val coordinateOfSquare = locationOfSquare()

  private def manhattenDistance = {
    Math.abs(center._2 - coordinateOfSquare._2) +
      Math.abs(center._1 - coordinateOfSquare._1)
  }
  def steps(): Long = manhattenDistance

}
