package com.marcastr0.adventofcode

import scala.io.Source

object Main extends App {
  val christmasTree =
    """
      |         *
      |        /|\
      |       /*|O\
      |      /*/|\*\
      |     /X/O|*\X\
      |    /*/X/|\X\*\
      |   /O/*/X|*\O\X\
      |  /*/O/X/|\X\O\*\
      | /X/O/*/X|O\X\*\O\
      |/O/X/*/O/|\X\*\O\X\
      |        |X|
      |        |X|
      |
      |ADVENT OF CODE 2017
      |
    """.stripMargin

  println(christmasTree)

  /*
   * Solution to Day 1: http://adventofcode.com/2017/day/1
   */
  val dayOneInput = Source.fromResource("DayOne.txt").getLines.mkString
  println("--- Day 1: Inverse Captcha ---")
  println("The solution to the captcha is " + DayOne.partOne(dayOneInput).toString)
  println("The solution to the new captcha is " + DayOne.partTwo(dayOneInput).toString)

  /*
   * Solution to Day 2: http://adventofcode.com/2017/day/2
   */
  val dayTwoInput = Source.fromResource("DayTwo.txt").getLines.mkString("\n")
  println("--- Day 2: Corruption Checksum ---")
  println("The checksum for the spreadsheet is " + DayTwo.partOne(dayTwoInput))
  println("The sum of each row's result in the spreadsheet is " + DayTwo.partTwo(dayTwoInput))

  /*
   * Solution to Day 3: http://adventofcode.com/2017/day/3
   */
  println("--- Day 3: Spiral Memory ---")
  val dayThreeInput = 289326
  println("The number of steps required are " + DayThree.partOne(dayThreeInput))
}
