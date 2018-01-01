package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayThirteenSpec extends FlatSpec {

  "partOne" should "return the severity of the whole trip" in {
    val firewall =
      """0: 3
        |1: 2
        |4: 4
        |6: 4""".stripMargin
    assert(DayThirteen.partOne(firewall) == 24)
  }
}
