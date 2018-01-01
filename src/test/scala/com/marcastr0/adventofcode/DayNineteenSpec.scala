package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayNineteenSpec extends FlatSpec {

  "convertRoutingDiagram" should "convert the routing diagram to a list of lists of characters" in {
    val routingDiagram =
      """     |
        #     |  +--+
        #     A  |  C
        # F---|----E|--+
        #     |  |  |  D
        #     +B-+  +--+""".stripMargin('#')
    val convertedDiagram = List(
      List(" ", " ", " ", " ", " ", "|", " ", " ", " ", " ", " ", " ", " ", " ", " "),
      List(" ", " ", " ", " ", " ", "|", " ", " ", "+", "-", "-", "+", " ", " ", " "),
      List(" ", " ", " ", " ", " ", "A", " ", " ", "|", " ", " ", "C", " ", " ", " "),
      List(" ", "F", "-", "-", "-", "|", "-", "-", "-", "-", "E", "|", "-", "-", "+"),
      List(" ", " ", " ", " ", " ", "|", " ", " ", "|", " ", " ", "|", " ", " ", "D"),
      List(" ", " ", " ", " ", " ", "+", "B", "-", "+", " ", " ", "+", "-", "-", "+"))
    assert(DayNineteen.convertRoutingDiagram(routingDiagram) == convertedDiagram)
  }

  "isPathChar" should "return whether a character is part of the path" in {
    assert(DayNineteen.isPathChar("|"))
    assert(DayNineteen.isPathChar("+"))
    assert(DayNineteen.isPathChar("-"))
    assert(!DayNineteen.isPathChar("A"))
  }

  "partOne" should "return the letters in the path" in {
    val routingDiagram =
      """     |
        #     |  +--+
        #     A  |  C
        # F---|----E|--+
        #     |  |  |  D
        #     +B-+  +--+""".stripMargin('#')
    assert(DayNineteen.partOne(routingDiagram) == "ABCDEF")
  }
}
