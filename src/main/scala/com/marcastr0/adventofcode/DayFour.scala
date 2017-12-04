package com.marcastr0.adventofcode

object DayFour {
  def isValidPassphrase(passphrase: String): Boolean = {
    val xs = passphrase.split(" ").toList
    xs.distinct.length == xs.length
  }

  def areAnagrams(w1: String, w2: String): Boolean = {
    w1.toList.sorted == w2.toList.sorted
  }

  def partOne(passphrases: String): Int = {
    val xs = passphrases.split("\n")
    xs.count(p => isValidPassphrase(p))
  }

  def partTwo(passphrases: String): Int = {
    val xs = passphrases.split("\n")
    val valid = for {
      p <- xs
      if p.split(" ").toSet.subsets(2).toList.filter(w => areAnagrams(w.head, w.tail.head)).length == 0
    } yield p
    valid.count(p => isValidPassphrase(p))
  }
}
