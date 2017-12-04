package com.marcastr0.adventofcode

object DayFour {
  def isValidPassphrase(passphrase: String): Boolean = {
    val l = passphrase.split(" ").toList
    l.distinct.length == l.length
  }

  def partOne(passphrases: String): Int = {
    val l = passphrases.split("\n")
    l.count(p => isValidPassphrase(p))
  }
}
