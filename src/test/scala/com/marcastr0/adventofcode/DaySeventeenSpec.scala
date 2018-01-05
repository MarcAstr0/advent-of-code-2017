package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DaySeventeenSpec extends FlatSpec {

  "partOne" should "return the value after the last value written" in {
    assert(DaySeventeen.partOne(3, 2017) == 638)
  }

  "partTwo" should "return the value after 0 the moment 50000000 is inserted" in {
    assert(DaySeventeen.partTwo(3, 8) == 5)
  }
}
