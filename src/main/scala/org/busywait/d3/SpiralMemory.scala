package org.busywait.d3

/*
  http://adventofcode.com/2017/day/3

  Memory allocated in a spiral outward from 1
    17  16  15  14  13
    18   5   4   3  12
    19   6   1   2  11
    20   7   8   9  10
    21  22  23---> ...
 */
object SpiralMemory {
  def steps(square: Long): Long = {
    val squaredCeil = Math.ceil(Math.sqrt(square)).asInstanceOf[Long]
    val squared = if (squaredCeil % 2 == 0) squaredCeil + 1 else squaredCeil
    val squaredHalf = Math.floor(squared.asInstanceOf[Double] / 2).asInstanceOf[Long]
    // Location of 1
    val center = (squaredHalf, squaredHalf)
    val highestNum = Math.pow(squared, 2).asInstanceOf[Long]

    def locationOfSquare(): (Long, Long) = {
      val cornerBottomRight = highestNum
      val cornerBottomLeft = highestNum - squared + 1
      val cornerTopLeft = cornerBottomLeft - squared + 1
      val cornerTopRight = cornerTopLeft - squared + 1

      if (cornerBottomLeft < square) (squared - 1, highestNum - square)
      else if (cornerTopLeft < square) (0L, cornerBottomLeft - square)
      else if (cornerTopRight < square) (0L, cornerTopLeft - square)
      else (squared - 1, cornerTopRight - square)
    }

    val coordinateOfSquare = locationOfSquare()

    def manhattenDistance = {
      Math.abs(center._2 - coordinateOfSquare._2) +
        Math.abs(center._1 - coordinateOfSquare._1)
    }

    manhattenDistance
  }

  /**
    * Calculate first value bigger than input
    *
    * @param value input
    * @return
    */
  def calculateAdjacentSquareValue(value: Long): Long = {
    def calculateNextLocation(location: (Int, Int)): (Int, Int) = {
      ???
    }
    def calculateValueForLocation(calculatedValueLocation: (Int, Int), matrix: Array[Array[Long]], newMatrix: Array[Array[Long]]): Long = {
      ???
    }

    def calculateAdjacentSquareValue(matrix: Array[Array[Long]]): Long = {
      val newMatrix = Array.ofDim[Long](matrix.length+2, matrix.length+2)
      val center = (
        Math.ceil(matrix.length.asInstanceOf[Double] / 2).asInstanceOf[Int],
        Math.ceil(matrix.length.asInstanceOf[Double] / 2).asInstanceOf[Int]
      )
      var calculatedValueLocation = center
      var calculatedValue = matrix(calculatedValueLocation._1)(calculatedValueLocation._2)

      while (calculatedValue < value) {
        calculatedValueLocation = calculateNextLocation(calculatedValueLocation)
        newMatrix(calculatedValueLocation._1)(calculatedValueLocation._2) = calculateValueForLocation(calculatedValueLocation, matrix, newMatrix)
        calculatedValue = matrix(calculatedValueLocation._1)(calculatedValueLocation._2)
      }

      calculatedValue
    }

    val input = Array.ofDim[Long](1, 1)
    input(0)(0) = 1 // kickstart
    calculateAdjacentSquareValue(input)
  }
}
