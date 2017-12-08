package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DaySevenSpec extends FlatSpec {

  "convertInput" should "convert the text input to a map of names to their weights and list of names" ignore {
    val input =
      """ktlj (57)
        |fwft (72) -> ktlj, cntj, xhth
        |qoyq (66)""".stripMargin
    assert(DaySeven.convertInput(input) == Map("ktlj" -> (57, List()),
      "fwft" -> (72, List("ktlj", "cntj", "xhth")),
      "qoyq" -> (66, List())))
  }

  "partOne" should "return the name of the bottom program" ignore {
    ???
  }

}
