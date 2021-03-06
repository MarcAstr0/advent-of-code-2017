package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayTwoSpec extends FlatSpec {
  "stringToSpreadsheet" should "convert a string with the spreadsheet to a list o lists with integers" in {
    val spreadsheet =
      """5	1	9	5
        |7	5	3
        |2	4	6	8""".stripMargin
    assert(DayTwo.stringToSpreadsheet(spreadsheet) == List(List(5, 1, 9, 5), List(7, 5, 3), List(2, 4, 6, 8)))
  }

  "getRowDifference" should "determine the difference between the largest value and the smallest value in the row" in {
    assert(DayTwo.getRowDifference(List(5, 1, 9, 5)) == 8)
    assert(DayTwo.getRowDifference(List(7, 5, 3)) == 4)
    assert(DayTwo.getRowDifference(List(2, 4, 6, 8)) == 6)
  }

  "partOne" should "calculate the spreadsheet's checksum" in {
    val spreadsheet =
      """5	1	9	5
        |7	5	3
        |2	4	6	8""".stripMargin
    assert(DayTwo.partOne(spreadsheet) == 18)
  }

  "getRowEvenDivision" should "determine the result of the division of the two numbers that divide evenly" in {
    assert(DayTwo.getRowEvenDivision(List(5, 9, 2, 8)) == 4)
    assert(DayTwo.getRowEvenDivision(List(9, 4, 7, 3)) == 3)
    assert(DayTwo.getRowEvenDivision(List(3, 8, 6, 5)) == 2)
  }

  "partTwo" should "calculate the spreadsheet's checksum" in {
    val spreadsheet =
      """5	9	2	8
        |9	4	7	3
        |3	8	6	5""".stripMargin
    assert(DayTwo.partTwo(spreadsheet) == 9)
  }
}
