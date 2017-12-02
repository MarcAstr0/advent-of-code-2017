package com.marcastr0.adventofcode

object DayTwo {
  def stringToSpreadsheet(spreadsheet: String): List[List[Int]] = {
    spreadsheet.split("\n").toList map {
      row => row.split("\t").toList.map(_.toInt)
    }
  }

  def getRowDifference(row: List[Int]): Int = {
    row.sorted.reverse.head - row.min
  }

  def partOne(spreadsheet: String): Int = {
    val xs = stringToSpreadsheet(spreadsheet) map (row => getRowDifference(row))
    xs.sum
  }
}
