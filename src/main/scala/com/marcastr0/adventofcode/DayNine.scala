package com.marcastr0.adventofcode

object DayNine {

  def partOne(input: String): Int = {
    val tokens = input.toList
    var i, score = 0
    var depth = 0
    var garbage = false
    while (i < tokens.length) {
      tokens(i) match {
        case '{' => if (!garbage) {
          depth += 1
          score += depth
        }
        case '}' => if (!garbage) depth -= 1
        case '<' => garbage = true
        case '>' => garbage = false
        case '!' => i += 1
        case _ =>
      }
      i += 1
    }
    score
  }

  def partTwo(input: String): Int = {
    val tokens = input.toList
    var i, garbageCount = 0
    var garbage = false
    while (i < tokens.length) {
      tokens(i) match {
        case '<' => if (!garbage) garbage = true else garbageCount += 1
        case '>' => if (garbage) garbage = false
        case '!' => i += 1
        case _ => if (garbage) garbageCount += 1
      }
      i += 1
    }
    garbageCount
  }
}
