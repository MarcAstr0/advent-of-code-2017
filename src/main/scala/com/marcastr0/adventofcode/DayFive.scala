package com.marcastr0.adventofcode

import scala.collection.mutable.ListBuffer

object DayFive {

  def partOne(offsets: String): Int = {
    val l = offsets.split("\n").toList map (_.toInt)
    var lb = l.to[ListBuffer]
    var steps, position = 0
    while (position < lb.length) {
      val current = position
      position += lb(current)
      lb(current) += 1
      steps += 1
    }
    steps
  }
}
