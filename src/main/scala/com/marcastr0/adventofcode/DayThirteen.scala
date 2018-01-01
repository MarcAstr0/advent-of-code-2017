package com.marcastr0.adventofcode

object DayThirteen {

  def partOne(input: String): Int = {
    val firewall = input.split("\n").toList
      .map(_.split(": ").toList.map(_.toInt))
      .map(x => x.head -> x.tail.head).toMap
    var severity = 0
    for (depth <- 1 to firewall.keys.max) {
      val range = firewall.getOrElse(depth, 0)
      if (range > 0) {
        if (depth % (2*(range-1)) == 0) severity += (depth * range)
      }
    }
    severity
  }

}
