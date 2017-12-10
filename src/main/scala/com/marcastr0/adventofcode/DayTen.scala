package com.marcastr0.adventofcode

object DayTen {

  def applyHash(input: List[Int], cp: Int, length: Int): List[Int] = {
    if (cp + length > input.length) {
      val xs1 = input ++ input
      val xs2 = xs1.slice(0, cp) ++ xs1.slice(cp, cp + length).reverse ++ xs1.slice(cp + length, xs1.length)
      xs2.slice(input.length, input.length + cp) ++ xs2.slice(cp, input.length)
    } else {
      input.slice(0, cp) ++ input.slice(cp, cp + length).reverse ++ input.slice(cp + length, input.length)
    }
  }

  def partOne(size: Int, lengths: String): Int = {
    val xs = {for (i <- 0 until size) yield i}.toList
    var xs1 = xs
    val lengthsList = lengths.split(",").toList map (_.toInt)
    var currentPosition, skipSize = 0
    for (length <- lengthsList) {
      xs1 = applyHash(xs1, currentPosition, length)
      currentPosition = (currentPosition + (length + skipSize)) % xs1.length
      skipSize += 1
    }
    xs1.head * xs1.tail.head
  }
}
