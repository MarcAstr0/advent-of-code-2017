package com.marcastr0.adventofcode

import scala.annotation.tailrec

object DaySixteen {

  def spin(p: List[Char], x: Int): List[Char] =
    p.drop(p.length - x) ++ p.take(p.length - x)
  def exchange(p: List[Char], a: Int, b: Int): List[Char] =
    p.updated(a, p(b)).updated(b, p(a))
  def partner(p: List[Char], a: Char, b: Char): List[Char] =
    p.updated(p.indexOf(a), p(p.indexOf(b))).updated(p.indexOf(b), p(p.indexOf(a)))

  def partOne(moves: String, programs: List[Char]): String = {
    val s = """(s)(\d+)""".r
    val x = """(x)(\d+)(\/)(\d+)""".r
    val p = """(p)(\w+)(\/)(\w+)""".r

    @tailrec
    def partOneRec(moves: List[String], programs: List[Char]): List[Char] = {
      if (moves.isEmpty) programs
      else {
        moves.head match {
          case s("s", a) => partOneRec(moves.tail, spin(programs, a.toInt))
          case x("x", a, "/", b) => partOneRec(moves.tail, exchange(programs, a.toInt, b.toInt))
          case p("p", a, "/", b) => partOneRec(moves.tail, partner(programs, a.head, b.head))
        }
      }
    }
    partOneRec(moves.split(",").toList, programs).mkString
  }
}
