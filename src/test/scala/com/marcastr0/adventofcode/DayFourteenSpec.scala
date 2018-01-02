package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayFourteenSpec extends FlatSpec {

  "partOne" should "return the number of used squares used across the grid" in {
    assert(DayFourteen.partOne("flqrgnkx") == 8108)
  }
}
