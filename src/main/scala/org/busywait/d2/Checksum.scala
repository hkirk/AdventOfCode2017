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
}
