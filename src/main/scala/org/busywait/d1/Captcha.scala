package org.busywait.d1

class Captcha(val input: String) {

  def captchaFP(): Long = {
    val inputArray = input.toCharArray.map(_.asDigit) // (1, 1, 2, 2)
    val wrapped = (input.tail + String.valueOf(input.head)).toCharArray.map(_.asDigit) // (1, 2, 2, 1)

    val zip = inputArray zip wrapped // (1, 1), (1, 2), (2, 2), 2, 1)
    val unique = zip.filter(p => p._1 == p._2)  // (1, 1), (2, 2)

    unique.foldLeft(0L)((sum, pair) => sum + pair._1)
  }

}
