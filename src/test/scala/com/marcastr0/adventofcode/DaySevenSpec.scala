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

  "partOne" should "return the name of the bottom program" in {
    val input =
      """pbga (66)
        |xhth (57)
        |ebii (61)
        |havc (66)
        |ktlj (57)
        |fwft (72) -> ktlj, cntj, xhth
        |qoyq (66)
        |padx (45) -> pbga, havc, qoyq
        |tknk (41) -> ugml, padx, fwft
        |jptl (61)
        |ugml (68) -> gyxo, ebii, jptl
        |gyxo (61)
        |cntj (57)""".stripMargin
    assert(DaySeven.partOne(input) == "tknk")
  }

}
