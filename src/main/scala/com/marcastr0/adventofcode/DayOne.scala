package com.marcastr0.adventofcode

object DayOne {

  def partOne(input: String): Int = {
    val xs1 = input.map(_.asDigit).toList
    val xs2 = xs1 ++ List(xs1.head)
    val xs3 = {
      for {
        List(left, right) <- xs2.sliding(2)
        if left == right
      } yield left
    }.toList
    xs3.sum
  }

}
