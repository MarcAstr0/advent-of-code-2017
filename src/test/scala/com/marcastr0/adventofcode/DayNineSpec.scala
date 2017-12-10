package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayNineSpec extends FlatSpec {

  "partOne" should "return the total score for all groups" in {
    assert(DayNine.partOne("{}") == 1)
    assert(DayNine.partOne("{{{}}}") == 6)
    assert(DayNine.partOne("{{},{}}") == 5)
    assert(DayNine.partOne("{{{},{},{{}}}}") == 16)
    assert(DayNine.partOne("{<a>,<a>,<a>,<a>}") == 1)
    assert(DayNine.partOne("{{<ab>},{<ab>},{<ab>},{<ab>}}") == 9)
    assert(DayNine.partOne("{{<!!>},{<!!>},{<!!>},{<!!>}}") == 9)
    assert(DayNine.partOne("{{<a!>},{<a!>},{<a!>},{<ab>}}") == 3)
  }

  "partTwo" should "return the number of non-canceled characters that are within the garbage" in {
    assert(DayNine.partTwo("<>") == 0)
    assert(DayNine.partTwo("<random characters>") == 17)
    assert(DayNine.partTwo("<<<<>") == 3)
    assert(DayNine.partTwo("<{!>}>") == 2)
    assert(DayNine.partTwo("<!!>") == 0)
    assert(DayNine.partTwo("<!!!>>") == 0)
    assert(DayNine.partTwo("<{o\"i!a,<{i<a>") == 10)
  }
}
