package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayElevenSpec extends FlatSpec {

  "partOne" should "determine the fewest number of steps required to reach the end in the path" in {
    assert(DayEleven.partOne("ne,ne,ne") == 3)
    assert(DayEleven.partOne("ne,ne,sw,sw") == 0)
    assert(DayEleven.partOne("ne,ne,s,s") == 2)
    assert(DayEleven.partOne("se,sw,se,sw,sw") == 3)
  }

}
