package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayThreeSpec extends FlatSpec {

  "getCoordinates" should "return the (x, y) coordinates of the square in the spiral matrix" in {
    assert(DayThree.getCoordinates(2) == (1, 0))
    assert(DayThree.getCoordinates(11) == (2, 0))
    assert(DayThree.getCoordinates(7) == (-1, -1))
    assert(DayThree.getCoordinates(25) == (2, -2))
    assert(DayThree.getCoordinates(17) == (-2, 2))
    assert(DayThree.getCoordinates(21) == (-2, -2))
  }

  "partOne" should "return the number of steps (calculate Manhattan distance) from the square to square one" in {
    assert(DayThree.partOne(1) == 0)
    assert(DayThree.partOne(12) == 3)
    assert(DayThree.partOne(23) == 2)
    assert(DayThree.partOne(1024) == 31)
  }
}
