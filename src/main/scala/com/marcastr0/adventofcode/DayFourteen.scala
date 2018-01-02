package com.marcastr0.adventofcode

object DayFourteen {

  def partOne(input: String): Int = {
    var used = 0
    for (row <- 0 to 127) {
      val hash = DayTen.partTwo(input + "-" + row.toString)
      val binary = hash.split("").toList map (BigInt(_, 16).toString(2)) map ("%s".format(_).replace(' ', '0'))
      used += binary.mkString.toList.count(_ == '1')
    }
    used
  }

}
