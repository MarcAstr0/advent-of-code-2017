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

  "partTwo" should "return the hash of the input string" in {
    assert(DayTen.partTwo("") == "a2582a3a0e66e6e86e3812dcb672a272")
    assert(DayTen.partTwo("AoC 2017") == "33efeb34ea91902bb2f59c9920caa6cd")
    assert(DayTen.partTwo("1,2,3") == "3efbe78a8d82f29979031a4aa0b16a9d")
    assert(DayTen.partTwo("1,2,4") == "63960835bcdc130f0b66d7ff4f6a5a8e")
  }
}
