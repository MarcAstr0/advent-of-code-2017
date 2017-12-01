package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayOneSpec extends FlatSpec {

  "partOne" should "return 0 when no digit matches the next" in {
    assert(DayOne.partOne(1234) == 0)
  }

  "partOne" should "return the sum of all digits that match the next digit" in {
    assert(DayOne.partOne(1122) == 3)
    assert(DayOne.partOne(1111) == 4)
    assert(DayOne.partOne(91212129) == 9)
  }
}
