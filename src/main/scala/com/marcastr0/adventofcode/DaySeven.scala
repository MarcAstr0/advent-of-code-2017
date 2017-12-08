package com.marcastr0.adventofcode

object DaySeven {

  def convertInput(input: String): Map[String, (Int, List[String])] = {
    val asList = input.split("\n").toList
    val program = """(\w+) \((\d+)\)( -> ){0,1}(.*)""".r
    val m = asList map {
      case program(a, b) => a -> (b.toInt, List())
      case program(a, b, _, d) => a -> (b.toInt, d.split(",").toList.map(_.trim))
    }
    m.toMap
  }

  def partOne(input: String): String = {
    val programs = convertInput(input)
    val programsWithParents = programs.map(_._2._2).filter(_.nonEmpty).flatten.toList.distinct
    val allPrograms = programs.keys
    (allPrograms filterNot programsWithParents.contains).head
  }

}
