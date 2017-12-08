package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayEightSpec extends FlatSpec {

  "getRegisters" should "return a map of all the registers with their values set to 0" in {
    val input =
      """b inc 5 if a > 1
        |a inc 1 if b < 5
        |c dec -10 if a >= 1
        |c inc -20 if c == 10""".stripMargin
    assert(DayEight.getRegisters(input) == collection.mutable.Map("a" -> 0, "b" -> 0, "c" -> 0))
  }

  "partOne" should "apply the operations and return the largest value in any register" in {
    val input =
      """b inc 5 if a > 1
        |a inc 1 if b < 5
        |c dec -10 if a >= 1
        |c inc -20 if c == 10""".stripMargin
    assert(DayEight.partOne(input) == 1)
  }

  "partTwo" should "return the highest value held in any register during the process" in {
    val input =
      """b inc 5 if a > 1
        |a inc 1 if b < 5
        |c dec -10 if a >= 1
        |c inc -20 if c == 10""".stripMargin
    assert(DayEight.partTwo(input) == 10)
  }
}
