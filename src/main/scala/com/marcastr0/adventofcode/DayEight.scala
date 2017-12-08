package com.marcastr0.adventofcode

object DayEight {

  def getRegisters(input: String): collection.mutable.Map[String, Int] = {
    val xs = input.split("\n").toList map (r => (r.split(" ").head, 0))
    collection.mutable.Map(xs.distinct: _*)
  }

  def partOne(input: String): Int = {
    val registers = getRegisters(input)
    val instructions = input.split("\n").toList map (_.split(" ").toList)
    for (i <- instructions) {
      i match {
        case List(x, "inc", v, "if", y, "<", w) => if (registers(y) < w.toInt) registers(x) += v.toInt
        case List(x, "inc", v, "if", y, ">", w) => if (registers(y) > w.toInt) registers(x) += v.toInt
        case List(x, "inc", v, "if", y, "<=", w) => if (registers(y) <= w.toInt) registers(x) += v.toInt
        case List(x, "inc", v, "if", y, ">=", w) => if (registers(y) >= w.toInt) registers(x) += v.toInt
        case List(x, "inc", v, "if", y, "==", w) => if (registers(y) == w.toInt) registers(x) += v.toInt
        case List(x, "inc", v, "if", y, "!=", w) => if (registers(y) != w.toInt) registers(x) += v.toInt
        case List(x, "dec", v, "if", y, "<", w) => if (registers(y) < w.toInt) registers(x) -= v.toInt
        case List(x, "dec", v, "if", y, ">", w) => if (registers(y) > w.toInt) registers(x) -= v.toInt
        case List(x, "dec", v, "if", y, "<=", w) => if (registers(y) <= w.toInt) registers(x) -= v.toInt
        case List(x, "dec", v, "if", y, ">=", w) => if (registers(y) >= w.toInt) registers(x) -= v.toInt
        case List(x, "dec", v, "if", y, "==", w) => if (registers(y) == w.toInt) registers(x) -= v.toInt
        case List(x, "dec", v, "if", y, "!=", w) => if (registers(y) != w.toInt) registers(x) -= v.toInt
      }
    }
    registers.toSeq.sortWith(_._2 > _._2).head._2
  }

  def partTwo(input: String): Int = {
    val registers = getRegisters(input)
    val instructions = input.split("\n").toList map (_.split(" ").toList)
    var max = 0
    for (i <- instructions) {
      i match {
        case List(x, "inc", v, "if", y, "<", w) => if (registers(y) < w.toInt) registers(x) += v.toInt
        case List(x, "inc", v, "if", y, ">", w) => if (registers(y) > w.toInt) registers(x) += v.toInt
        case List(x, "inc", v, "if", y, "<=", w) => if (registers(y) <= w.toInt) registers(x) += v.toInt
        case List(x, "inc", v, "if", y, ">=", w) => if (registers(y) >= w.toInt) registers(x) += v.toInt
        case List(x, "inc", v, "if", y, "==", w) => if (registers(y) == w.toInt) registers(x) += v.toInt
        case List(x, "inc", v, "if", y, "!=", w) => if (registers(y) != w.toInt) registers(x) += v.toInt
        case List(x, "dec", v, "if", y, "<", w) => if (registers(y) < w.toInt) registers(x) -= v.toInt
        case List(x, "dec", v, "if", y, ">", w) => if (registers(y) > w.toInt) registers(x) -= v.toInt
        case List(x, "dec", v, "if", y, "<=", w) => if (registers(y) <= w.toInt) registers(x) -= v.toInt
        case List(x, "dec", v, "if", y, ">=", w) => if (registers(y) >= w.toInt) registers(x) -= v.toInt
        case List(x, "dec", v, "if", y, "==", w) => if (registers(y) == w.toInt) registers(x) -= v.toInt
        case List(x, "dec", v, "if", y, "!=", w) => if (registers(y) != w.toInt) registers(x) -= v.toInt
      }
      val currentMax = registers.toSeq.sortWith(_._2 > _._2).head._2
      if (currentMax > max) max = currentMax
    }
    max
  }
}
