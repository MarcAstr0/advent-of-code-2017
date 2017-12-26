package com.marcastr0.adventofcode

import scala.annotation.tailrec

object DayFifteen {

  def intTo32Bit(n: BigInt): List[Int] = {
    n.toString(2).toList.map(_.asDigit).reverse.padTo(32, 0).reverse
  }

  def compareBinaryPairs(p1: List[Int], p2: List[Int]): Boolean = {
    p1.drop(16) == p2.drop(16)
  }

  def partOne(startA: Int, startB: Int,
              factorA: Int, factorB: Int,
              divisor: Int, iterations: Int): Int = {
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

  def generateValues(start: BigInt, factor: Int, divisor: Int, multipleOf: Int, iterations: Int): List[BigInt] = {

    @tailrec
    def generateValuesRec(start: BigInt, factor: Int, divisor: Int, multipleOf: Int, iterations: Int, values: List[BigInt]): List[BigInt] = {
      if (values.length == iterations) values
      else {
        val value = (start * factor) % divisor
        if (value % multipleOf == 0) {
          val newValues = values ++ List(value)
          generateValuesRec(value, factor, divisor, multipleOf, iterations, newValues)
        } else {
          generateValuesRec(value, factor, divisor, multipleOf, iterations, values)
        }
      }
    }

    generateValuesRec(start, factor, divisor, multipleOf, iterations, List())
  }

  // @TODO: partTwo takes a really long time, maybe recursion was a bad idea?
  def partTwo(startA: Int, startB: Int,
              factorA: Int, factorB: Int,
              multipleOfA: Int, multipleOfB: Int,
              divisor: Int, iterations: Int): Int = {
    val a = generateValues(startA, factorA, divisor, multipleOfA, iterations)
    val b = generateValues(startB, factorB, divisor, multipleOfB, iterations)
    (a zip b).count(x => compareBinaryPairs(intTo32Bit(x._1), intTo32Bit(x._2)))
  }
}
