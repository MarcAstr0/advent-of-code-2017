package com.marcastr0.adventofcode

object DayEleven {

  /*
   * Inspired by this blog post: https://www.redblobgames.com/grids/hexagons/
   */
  case class Hex(x: Int, y: Int, z: Int)

  def move(hex: Hex, direction: String): Hex = {
    direction match {
      case "n" => Hex(hex.x + 1, hex.y, hex.z - 1)
      case "ne" => Hex(hex.x + 1, hex.y - 1, hex.z)
      case "nw" => Hex(hex.x, hex.y + 1, hex.z - 1)
      case "s" => Hex(hex.x - 1, hex.y, hex.z + 1)
      case "se" => Hex(hex.x, hex.y - 1, hex.z + 1)
      case "sw" => Hex(hex.x - 1, hex.y + 1, hex.z)
    }
  }

  def distance(hex1: Hex, hex2: Hex): Int = {
    (Math.abs(hex1.x - hex2.x) + Math.abs(hex1.y - hex2.y) + Math.abs(hex1.z - hex2.z)) / 2
  }

  def partOne(path: String): Int = {
    val steps = path.split(',').toList
    var position = Hex(0, 0, 0)
    for (step <- steps) {
      position = move(position, step)
    }
    distance(Hex(0 ,0, 0), position)
  }

  def partTwo(path: String): Int = {
    val steps = path.split(',').toList
    var position = Hex(0, 0, 0)
    var max = 0
    for (step <- steps) {
      position = move(position, step)
      if (distance(Hex(0 ,0, 0), position) > max) max = distance(Hex(0 ,0, 0), position)
    }
    max
  }

}
