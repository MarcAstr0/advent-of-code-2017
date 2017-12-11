package com.marcastr0.adventofcode

import com.marcastr0.adventofcode.DayEleven.Hex
import org.scalatest.FlatSpec

class DayElevenSpec extends FlatSpec {

  "move" should "return the correct position in cube coordinates after moving" in {
    assert(DayEleven.move(Hex(0, 0, 0), "n") == Hex(1, 0, -1))
    assert(DayEleven.move(Hex(0, 0, 0), "ne") == Hex(1, -1, 0))
    assert(DayEleven.move(Hex(0, 0, 0), "se") == Hex(0, -1, 1))
    assert(DayEleven.move(Hex(0, 0, 0), "s") == Hex(-1, 0, 1))
    assert(DayEleven.move(Hex(0, 0, 0), "sw") == Hex(-1, 1, 0))
    assert(DayEleven.move(Hex(0, 0, 0), "nw") == Hex(0, 1, -1))
  }

  "distance" should "return the distance between to hex tiles" in {
    assert(DayEleven.distance(Hex(0, 0, 0), Hex(1, -1, 0)) == 1)
    assert(DayEleven.distance(Hex(0, 0, 0), Hex(2, 0, -2)) == 2)
    assert(DayEleven.distance(Hex(0, 0, 0), Hex(-1, 3, -2)) == 3)
  }

  "partOne" should "determine the fewest number of steps required to reach the end in the path" in {
    assert(DayEleven.partOne("ne,ne,ne") == 3)
    assert(DayEleven.partOne("ne,ne,sw,sw") == 0)
    assert(DayEleven.partOne("ne,ne,s,s") == 2)
    assert(DayEleven.partOne("se,sw,se,sw,sw") == 3)
  }

}
