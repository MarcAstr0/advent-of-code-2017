package com.marcastr0.adventofcode

import com.marcastr0.adventofcode.DaySeven.Tower
import org.scalatest.FlatSpec

class DaySevenSpec extends FlatSpec {

  "convertInput" should "convert the text input to a map of names to their weights and list of names" in {
    val input =
      """ktlj (57)
        |fwft (72) -> ktlj, cntj, xhth
        |qoyq (66)""".stripMargin
    assert(DaySeven.convertInput(input) == Map("ktlj" -> (57, List("")),
      "fwft" -> (72, List("ktlj", "cntj", "xhth")),
      "qoyq" -> (66, List(""))))
  }

  val input: String =
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
  val tower: Tower = DaySeven.convertInput(input)

  "partOne" should "return the name of the bottom program" in {
    assert(DaySeven.partOne(input) == "tknk")
  }

  "calculateWeight" should "return the weight of the sub-tower" in {
    assert(DaySeven.calculateWeight("ugml", tower) == 251)
    assert(DaySeven.calculateWeight("padx", tower) == 243)
    assert(DaySeven.calculateWeight("fwft", tower) == 243)
  }

  "isBalanced" should "return true if a sub-tower is balanced or not" in {
    assert(DaySeven.isBalanced("ugml", tower))
    assert(DaySeven.isBalanced("padx", tower))
    assert(DaySeven.isBalanced("fwft", tower))
    assert(!DaySeven.isBalanced("tknk", tower))
  }

  "partTwo" should "return the weight needed for the program to balance the tower" in {
    assert(DaySeven.partTwo(input) == 60)
  }

}
