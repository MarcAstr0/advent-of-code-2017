package com.marcastr0.adventofcode

object DayTwelve {

  def contains0(p: Int, m: Map[Int, List[Int]]): Boolean = {
    ???
  }

  def partOne(list: String): Int = {
    val programs = list.split("\n").toList map (_.split(" <-> ").toList) map (x => (x.head.toInt, x.tail.head.split(",").toList.map(_.trim.toInt)))
    ???
  }

}
