package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayFourSpec extends FlatSpec {

  "isValidPassphrase" should "must return true if the passphrase does not contain duplicate words" in {
    assert(DayFour.isValidPassphrase("aa bb cc dd ee"))
    assert(!DayFour.isValidPassphrase("aa bb cc dd aa"))
    assert(DayFour.isValidPassphrase("aa bb cc dd aaa"))
  }

  "partOne" should "count the valid passphrases from a list" in {
    val passphraseList =
      """aa bb cc dd ee
        |aa bb cc dd aa
        |aa bb cc dd aaa""".stripMargin
    assert(DayFour.partOne(passphraseList) == 2)
  }
}
