package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DaySixSpec extends FlatSpec {

  "redistribute" should "apply a redistribution cycle" in {
    assert(DaySix.redistribute(List(0, 2, 7, 0)) == List(2, 4, 1, 2))
    assert(DaySix.redistribute(List(2, 4, 1, 2)) == List(3, 1, 2, 3))
    assert(DaySix.redistribute(List(3, 1, 2, 3)) == List(0, 2, 3, 4))
    assert(DaySix.redistribute(List(0, 2, 3, 4)) == List(1, 3, 4, 1))
    assert(DaySix.redistribute(List(1, 3, 4, 1)) == List(2, 4, 1, 2))
  }

  "partOne" should "return the number of cycles before an infinite loop" in {
    assert(DaySix.partOne("0	2	7	0") == 5)
  }

}
