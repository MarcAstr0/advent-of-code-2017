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
  //println("It takes " + DayFive.partOne(dayFiveInput) + " steps to reach the exit")
  //println("It takes " + DayFive.partTwo(dayFiveInput) + " steps to reach the exit with the new rule")
  println

  /*
   * Solution for Day 6: http://adventofcode.com/2017/day/6
   */
  println("--- Day 6: Memory Reallocation ---")
  val daySixInput = "0	5	10	0	11	14	13	4	11	8	8	7	1	4	12	11"
  println(DaySix.partOne(daySixInput) + " distribution cycles must be completed before entering an infinite loop")
  println("There are " + DaySix.partTwo(daySixInput) + " cycles in the infinite loop")
  println

  /*
   * Solution for Day 7: http://adventofcode.com/2017/day/7
   */
  println("--- Day 7: Recursive Circus ---")
  val daySevenInput = Source.fromResource("DaySeven.txt").getLines.mkString("\n")
  println("The name of the bottom program is " + DaySeven.partOne(daySevenInput))
  // @TODO: Part 2 of Day 7
  println

  /*
   * Solution for Day 8: http://adventofcode.com/2017/day/8
   */
  println("--- Day 8: I Heard You Like Registers ---")
  val dayEightInput = Source.fromResource("DayEight.txt").getLines.mkString("\n")
  println("The largest value in any register after completing the instructions is " + DayEight.partOne(dayEightInput))
  println("The highest value held in any register during the process is " + DayEight.partTwo(dayEightInput))
  println

  /*
   * Solution for Day 9: http://adventofcode.com/2017/day/9
   */
  println("--- Day 9: Stream Processing ---")
  val dayNineInput = Source.fromResource("DayNine.txt").getLines.mkString
  println("The total score for all groups in the input is " + DayNine.partOne(dayNineInput))
  println("The total of non-canceled characters that are within the garbage are " + DayNine.partTwo(dayNineInput))
  println

  /*
   * Solution for Day 10: http://adventofcode.com/2017/day/10
   */
  println("--- Day 10: Knot Hash ---")
  val dayTenInput = "106,16,254,226,55,2,1,166,177,247,93,0,255,228,60,36"
  println("The result of multiplying the first two numbers in the list after applying the hashes is " + DayTen.partOne(256, dayTenInput))
  // @TODO: Part 2 of Day 10
  println

  /*
   * Solution for Day 11: http://adventofcode.com/2017/day/11
   */
  println("--- Day 11: Hex Ed ---")
  val dayElevenInput = Source.fromResource("DayEleven.txt").getLines.mkString
  println("The fewest number of steps required are " + DayEleven.partOne(dayElevenInput))
  println("The furthest number of steps he ever got was " + DayEleven.partTwo(dayElevenInput))
  println

  /*
   * Solution for Day 12: http://adventofcode.com/2017/day/12
   */
  println("--- Day 12: Digital Plumber ---")
  val dayTwelveInput = Source.fromResource("DayTwelve.txt").getLines.mkString("\n")
  println("The number of programs in the group that contain program ID 0 is " + DayTwelve.partOne(dayTwelveInput))
  println("The are " + DayTwelve.partTwo(dayTwelveInput) + " groups")
  println

  /*
   * Solution for Day 13: http://adventofcode.com/2017/day/13
   */
  // @TODO: Find solution for Day 13

  /*
   * Solution for Day 14: http://adventofcode.com/2017/day/14
   */
  // @TODO: Find solution for Day 14

  /*
   * Solution for Day 15: http://adventofcode.com/2017/day/15
   */
  println("--- Day 15: Dueling Generators ---")
  val startA = 591
  val startB = 393
  val factorA = 16807
  val factorB = 48271
  val iterations = 40000000
  val divisor = 2147483647
  //println("The judge's final count is " + DayFifteen.partOne(startA, startB, factorA, factorB, divisor, iterations))
  //println("The judge's new final count is " + DayFifteen.partTwo(startA, startB, factorA, factorB, 4, 8, divisor, 5000000))
  println

  /*
   * Solution for Day 16: http://adventofcode.com/2017/day/16
   */
  // @TODO: Find solution for Day 16

  /*
   * Solution for Day 17: http://adventofcode.com/2017/day/17
   */
  // @TODO: Find solution for Day 17

  /*
   * Solution for Day 18: http://adventofcode.com/2017/day/18
   */
  println("--- Day 18: Duet ---")
  val dayEighteenInput = Source.fromResource("DayEighteen.txt").getLines.mkString("\n")
  println("The value of the recovered frequency is " + DayEighteen.partOne(dayEighteenInput))
  println
}
