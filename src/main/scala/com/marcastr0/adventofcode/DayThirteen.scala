package com.marcastr0.adventofcode

object DayThirteen {

  def partOne(input: String): Int = {
    val firewall = input.split("\n").toList
      .map(_.split(": ").toList.map(_.toInt))
      .map(x => x.head -> x.tail.head).toMap
    firewall.filter{case (depth, range) =>depth % (2*(range-1)) == 0}
      .map{case (depth, range) => depth*range}.toList.sum
  }

  def partTwo(input: String): Int = {
    val firewall = input.split("\n").toList
      .map(_.split(": ").toList.map(_.toInt))
      .map(x => x.head -> x.tail.head).toMap
    var delay = 0
    var break = false
    while(!break) {
      val caught = firewall.filter{case (depth, range) => (depth + delay) % (2*(range-1)) == 0}
      if (caught.isEmpty) break = true else delay += 1
    }
    delay
  }
}
