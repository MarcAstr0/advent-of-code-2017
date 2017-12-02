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

  def getRowEvenDivision(row: List[Int]): Int = {
    val pairs = row.toSet.subsets(2).toList
    val evenlyDivisible = (pairs filter (s => s.head % s.tail.head == 0 || s.tail.head % s.head == 0)).head.toList.sorted
    evenlyDivisible.tail.head / evenlyDivisible.head
  }

  def partTwo(spreadsheet: String): Int = {
    val xs = stringToSpreadsheet(spreadsheet) map (row => getRowEvenDivision(row))
    xs.sum
  }
}
