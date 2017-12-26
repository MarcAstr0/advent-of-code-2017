package com.marcastr0.adventofcode

object DayEighteen {

  def initRegisters(input: String): collection.mutable.Map[Char, BigInt] = {
    val registers = input.split("\n").toList.map(_.split(" ")(1).head).distinct.filter(!_.toString.isNumeric)
    collection.mutable.Map(registers.map((_, 0: BigInt)): _*)
  }

  def partOne(input: String): BigInt = {
    val registers = initRegisters(input)
    val instructions = input.split("\n").toList
    var position, i = 0
    var sound: BigInt = 0
    var break = false
    while(!break) {
      instructions(position).split(" ").toList match {
        case List("snd", x) => sound = registers(x.head); position += 1
        case List("set", x, y) =>
          if (y.isNumeric) registers(x.head) = y.toInt else registers(x.head) = registers(y.head)
          position += 1
        case List("add", x, y) =>
          if (y.isNumeric) registers(x.head) += y.toInt else registers(x.head) += registers(y.head)
          position += 1
        case List("mul", x, y) =>
          if (y.isNumeric) registers(x.head) *= y.toInt else registers(x.head) *= registers(y.head)
          position += 1
        case List("mod", x, y) =>
          if (y.isNumeric) registers(x.head) %= y.toInt else registers(x.head) %= registers(y.head)
          position += 1
        case List("rcv", x) => if (registers(x.head) != 0) break = true else position += 1
        case List("jgz", x, y) => if ((x.isNumeric && x.toInt > 0) || (!x.isNumeric && registers(x.head) > 0))
          position += y.toInt else position += 1
      }
    }
    sound
  }

  // Taken from https://stackoverflow.com/questions/31983084/how-do-i-validate-a-numeric-character-in-scala
  implicit class OpsNum(val str: String) extends AnyVal {
    def isNumeric = scala.util.Try(str.toDouble).isSuccess
  }
}
