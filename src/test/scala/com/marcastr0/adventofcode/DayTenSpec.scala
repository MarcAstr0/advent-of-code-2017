package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayTenSpec extends FlatSpec {

  "applyHash" should "apply the hash function to the list given the current position" in {
    assert(DayTen.applyHash(List(0, 1, 2, 3, 4), 0, 3) == List(2, 1, 0, 3, 4))
    assert(DayTen.applyHash(List(2, 1, 0, 3, 4), 3, 4) == List(4, 3, 0, 1, 2))
    assert(DayTen.applyHash(List(4, 3, 0, 1, 2), 3, 1) == List(4, 3, 0, 1, 2))
    assert(DayTen.applyHash(List(4, 3, 0, 1, 2), 1, 5) == List(3, 4, 2, 1, 0))
  }

  "partOne" should "return the result of multiplying the first two numbers in the list after applying the hashes" in {
    val lengths = "3,4,1,5"
    assert(DayTen.partOne(5, lengths) == 12)
  }
}
