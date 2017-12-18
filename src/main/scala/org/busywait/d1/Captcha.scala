package org.busywait.d1

class Captcha(val input: String) {
  def captchaHalfway(): Long = captcha(input.length / 2)
  def captchaFP(): Long = captcha(1)

  private def captcha(steps: Int, print: Boolean = false): Long = {
    val inputArray = input.toCharArray.map(_.asDigit) // (1, 1, 2, 2)
    val circular = Iterator.continually(input.toCharArray).take(2).toList.flatten
    if (print) println("Circular: " + circular)
    val wrapped = circular.slice(steps, steps + input.length).map(_.asDigit) // (1, 2, 2, 1)
    if (print) println("Wrapped: " + wrapped)

    val zip = inputArray zip wrapped // (1, 1), (1, 2), (2, 2), 2, 1)
    val unique = zip.filter(p => p._1 == p._2)  // (1, 1), (2, 2)

    unique.foldLeft(0L)((sum, pair) => sum + pair._1)
  }
}
