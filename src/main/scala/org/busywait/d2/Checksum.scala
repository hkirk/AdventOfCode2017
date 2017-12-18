package org.busywait.d2

class Checksum(input: String) {
  private val rows: List[List[Int]] = input.split('\n').map(row => {
    row.split(Array(' ', '\t')).filter(num => num.trim.nonEmpty).map(v => {
      Integer.valueOf(v.trim).toInt
    }).toList
  }).toList



  def calculateChecksum(): Long = {
    rows.map(list => {
      val max = list.reduceLeft((a, b) => if (a > b) a else b)
      val min = list.reduceLeft((a, b) => if (a < b) a else b)

      max - min
    }).sum
  }

  def calculateChecksumEvenlyDivisibleValues(): Long = {
    def findEvenlyDivisibleValue(values: List[Int]): Long = {
      val divisor = for {
        i <- values
        j <- values
        if i != j
        if i % j == 0
      } yield (i, j)

      divisor.head._1 / divisor.head._2
    }

    val result = rows map(column => {
      findEvenlyDivisibleValue(column.sortWith(_ > _))
    })

    result.sum
  }
}
