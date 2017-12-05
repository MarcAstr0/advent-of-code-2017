package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayFiveSpec extends FlatSpec {

  "partOne" should "return the number of steps needed to reach the exit" in {
    val offsets =
      """0
        |3
        |0
        |1
        |-3""".stripMargin
    assert(DayFive.partOne(offsets) == 5)
  }

}
