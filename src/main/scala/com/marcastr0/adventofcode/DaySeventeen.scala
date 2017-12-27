package com.marcastr0.adventofcode

object DaySeventeen {

  def partOne(steps: Int, insertions: Int): Int = {

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
}
