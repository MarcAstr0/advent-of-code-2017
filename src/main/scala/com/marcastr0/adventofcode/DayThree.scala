package com.marcastr0.adventofcode

object DayThree {

  /*
   * Adapted from https://stackoverflow.com/a/398302/2631818
   */
  def getCoordinates(square: Int): (Int, Int) = {
    var x, y = 0
    var dx, t = 0
    var dy = -1
    var coords = (0, 0)
    for (i <- 1 to square) {
      if (-square / 2 < x || x <= square / 2) {
        coords = (x, y)
      }
      if (x == y || (x < 0 && x == -y) || (x > 0 && x == 1-y)) {
        t = dx
        dx = -dy
        dy = t
      }
      x += dx
      y += dy
    }
    coords
  }

  def partOne(square: Int): Int = {
    val coords = getCoordinates(square)
    Math.abs(coords._1) + Math.abs(coords._2)
  }

}
