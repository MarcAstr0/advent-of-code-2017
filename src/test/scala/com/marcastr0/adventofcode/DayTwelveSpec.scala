package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayTwelveSpec extends FlatSpec {

  "contains0" should "return true or false whether it's connected to 0 or not" in {
    val input =
      """0 <-> 2
        |1 <-> 1
        |2 <-> 0, 3, 4
        |3 <-> 2, 4
        |4 <-> 2, 3, 6
        |5 <-> 6
        |6 <-> 4, 5""".stripMargin
    val m = input.split("\n").toList map (_.split(" <-> ").toList) map (x => (x.head.toInt, x.tail.head.split(",").toList.map(_.trim.toInt)))
    assert(DayTwelve.contains0(0, m.toMap))
    assert(!DayTwelve.contains0(1, m.toMap))
    assert(DayTwelve.contains0(2, m.toMap))
    assert(DayTwelve.contains0(3, m.toMap))
    assert(DayTwelve.contains0(4, m.toMap))
    assert(DayTwelve.contains0(5, m.toMap))
    assert(DayTwelve.contains0(6, m.toMap))
  }

  "partOne" should "return the number of programs that are in the group that contains program ID 0" ignore {
    val input =
      """0 <-> 2
        |1 <-> 1
        |2 <-> 0, 3, 4
        |3 <-> 2, 4
        |4 <-> 2, 3, 6
        |5 <-> 6
        |6 <-> 4, 5""".stripMargin
    assert(DayTwelve.partOne(input) == 6)
  }

}
