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
  println("+++ Day One +++")
  println("The solution to the captcha is " + DayOne.partOne(dayOneInput).toString)
  println("The solution to the new captcha is " + DayOne.partTwo(dayOneInput).toString)
}