package com.marcastr0.adventofcode

import scala.collection.mutable.ListBuffer

object DaySix {

  def redistribute(banks: List[Int]): List[Int] = {
    val maxIdx = banks.indices.maxBy(banks)
    var maxVal = banks.max
    val lb = banks.take(maxIdx).to[ListBuffer] ++ ListBuffer(0) ++ banks.drop(maxIdx + 1).to[ListBuffer]
    var current = if (maxIdx + 1 == banks.length) 0 else maxIdx + 1
    while (maxVal > 0) {
      lb(current) += 1
      current = if (current + 1 == banks.length) 0 else current + 1
      maxVal -= 1
    }
    lb.toList
  }

  def partOne(banks: String): Int = {
    val initial = banks.split("\t").toList map(_.toInt)
    var cycle = redistribute(initial)
    val cycles = ListBuffer(initial)
    while (!cycles.contains(cycle)) {
      cycles += cycle
      cycle = redistribute(cycle)
    }
    cycles.length
  }

  def partTwo(banks: String): Int = {
    val initial = banks.split("\t").toList map(_.toInt)
    var cycle = redistribute(initial)
    val cycles = ListBuffer(initial)
    while (!cycles.contains(cycle)) {
      cycles += cycle
      cycle = redistribute(cycle)
    }
    cycles.length - cycles.indexOf(cycle)
  }

}
