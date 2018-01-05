package com.marcastr0.adventofcode

import scala.annotation.tailrec

object DaySeventeen {

  def partOne(steps: Int, insertions: Int): Int = {

    @tailrec
    def partOneRec(iteration: Int, position: Int, buffer: List[Int]): List[Int] = {
      if (iteration > insertions) buffer
      else {
        val i = (position + steps) % buffer.length
        val newBuffer = buffer.take(i + 1) ++ List(iteration + 1) ++ buffer.drop(i + 1)
        partOneRec(iteration + 1, i + 1, newBuffer)
      }
    }
    val b = partOneRec(0, 0, List(0))
    b(b.indexOf(insertions) + 1)
  }

  def partTwo(steps: Int, iterations: Int): Int = {
    var i = 0
    var afterZero = 0
    for (iteration <- 1 to iterations) {
      i = (i + steps)%iteration + 1
      if (i == 1) afterZero = iteration
    }
    afterZero
  }
}
