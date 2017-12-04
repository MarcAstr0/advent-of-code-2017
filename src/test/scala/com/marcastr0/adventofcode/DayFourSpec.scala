package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayFourSpec extends FlatSpec {

  "isValidPassphrase" should "must return true if the passphrase does not contain duplicate words" in {
    assert(DayFour.isValidPassphrase("aa bb cc dd ee"))
    assert(!DayFour.isValidPassphrase("aa bb cc dd aa"))
    assert(DayFour.isValidPassphrase("aa bb cc dd aaa"))
  }

  "areAnagrams" should "return true if two words are anagrams" in {
    assert(!DayFour.areAnagrams("abcde", "fghij"))
    assert(DayFour.areAnagrams("abcde", "ecdab"))
    assert(!DayFour.areAnagrams("a", "ab"))
  }

  "partOne" should "count the valid passphrases from a list" in {
    val passphraseList =
      """aa bb cc dd ee
        |aa bb cc dd aa
        |aa bb cc dd aaa""".stripMargin
    assert(DayFour.partOne(passphraseList) == 2)
  }

  "partTwo" should "count the valid passphrases using the added system policy" in {
    val passphraseList =
      """abcde fghij
        |abcde xyz ecdab
        |a ab abc abd abf abj
        |iiii oiii ooii oooi oooo
        |oiii ioii iioi iiio""".stripMargin
    assert(DayFour.partTwo(passphraseList)== 3)
  }
}
