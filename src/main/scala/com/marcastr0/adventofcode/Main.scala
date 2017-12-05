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
   * Solution for Day 1: http://adventofcode.com/2017/day/1
   */
  val dayOneInput = Source.fromResource("DayOne.txt").getLines.mkString
  println("--- Day 1: Inverse Captcha ---")
  println("The solution to the captcha is " + DayOne.partOne(dayOneInput).toString)
  println("The solution to the new captcha is " + DayOne.partTwo(dayOneInput).toString)
  println

  /*
   * Solution for Day 2: http://adventofcode.com/2017/day/2
   */
  val dayTwoInput = Source.fromResource("DayTwo.txt").getLines.mkString("\n")
  println("--- Day 2: Corruption Checksum ---")
  println("The checksum for the spreadsheet is " + DayTwo.partOne(dayTwoInput))
  println("The sum of each row's result in the spreadsheet is " + DayTwo.partTwo(dayTwoInput))
  println

  /*
   * Solution for Day 3: http://adventofcode.com/2017/day/3
   */
  println("--- Day 3: Spiral Memory ---")
  val dayThreeInput = 289326
  println("The number of steps required are " + DayThree.partOne(dayThreeInput))
  println

  /*
   * Solution for Day 4: http://adventofcode.com/2017/day/4
   */
  println("--- Day 4: High-Entropy Passphrases ---")
  val dayFourInput = Source.fromResource("DayFour.txt").getLines.mkString("\n")
  println("There are " + DayFour.partOne(dayFourInput) + " valid passphrases")
  println("There are " + DayFour.partTwo(dayFourInput) + " valid passphrases with the added security")
  println

  /*
   * Solution for Day 5: http://adventofcode.com/2017/day/5
   */
  println("--- Day 5: A Maze of Twisty Trampolines, All Alike ---")
  val dayFiveInput = Source.fromResource("DayFive.txt").getLines.mkString("\n")
  println("It takes " + DayFive.partOne(dayFiveInput) + " steps to reach the exit")
  println
}
