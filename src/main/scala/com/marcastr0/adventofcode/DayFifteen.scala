package com.marcastr0.adventofcode

object DayFifteen {

  def intTo32Bit(n: BigInt): List[Int] = {
    n.toString(2).toList.map(_.asDigit).reverse.padTo(32, 0).reverse
  }

  def compareBinaryPairs(p1: List[Int], p2: List[Int]): Boolean = {
    p1.drop(16) == p2.drop(16)
  }

  def partOne(startA: Int, startB: Int, factorA: Int, factorB: Int, divisor: Int, iterations: Int): Int = {
    var matches = 0
    var a: BigInt = startA
    var b: BigInt = startB
    for (i <- 1 to iterations) {
      a = (a * factorA) % divisor
      b = (b * factorB) % divisor
      if (compareBinaryPairs(intTo32Bit(a), intTo32Bit(b))) matches += 1
    }
    matches
  }
}
