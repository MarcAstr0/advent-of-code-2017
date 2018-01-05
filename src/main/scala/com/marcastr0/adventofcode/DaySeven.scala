package com.marcastr0.adventofcode

import scala.annotation.tailrec

object DaySeven {
  type Tower = Map[String, (Int, List[String])]

  def convertInput(input: String): Tower = {
    val asList = input.split("\n").toList
    val program = """(\w+) \((\d+)\)( -> ){0,1}(.*)""".r
    val m = asList map {
      case program(a, b) => a -> (b.toInt, List())
      case program(a, b, _, d) => a -> (b.toInt, d.split(",").toList.map(_.trim))
    }
    m.toMap
  }

  def partOne(input: String): String = {
    val tower = convertInput(input)
    val programsWithParents = tower.map(_._2._2).filter(_.nonEmpty).flatten.toList.distinct
    val allPrograms = tower.keys
    (allPrograms filterNot programsWithParents.contains).head
  }

  def calculateWeight(program: String, tower: Tower): Int = {
    if (tower(program)._2 == List("")) tower(program)._1
    else tower(program)._1 + tower(program)._2.map(calculateWeight(_, tower)).sum
  }

  def isBalanced(program: String, tower: Tower): Boolean = {
    if (tower(program)._2 == List("")) true
    else
      tower(program)._2.map(calculateWeight(_, tower)).sum ==
      tower(program)._2.map(calculateWeight(_, tower)).head * tower(program)._2.length
  }

  def partTwo(input: String): Int = {
    val tower = convertInput(input)
    val bottom = partOne(input)

    @tailrec
    def partTwoRec(different: String, same: String, tower: Tower): (String, String) = {
      if (isBalanced(different, tower)) (different, same)
      else {
        val weights = tower(different)._2.map(x => (x, calculateWeight(x, tower))).toMap
        val weightsWithCounts = weights.foldLeft(Map[Int, Int]() withDefaultValue 0) {(m, x) => m + (x._2 -> (m(x._2) + 1))}
        val diff = weights.filterNot(x => weightsWithCounts(x._2) > 1).head._1
        val sm = weights.filter(x => weightsWithCounts(x._2) > 1).head._1
        partTwoRec(diff, sm, tower)
      }
    }

    val programs = partTwoRec(bottom, "", tower)
    tower(programs._1)._1 + (calculateWeight(programs._2, tower) - calculateWeight(programs._1, tower))
  }

}
