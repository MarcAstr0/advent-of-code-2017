package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DaySixteenSpec extends FlatSpec {

  "spin" should "make x programs move to the front" in {
    assert(DaySixteen.spin(List('a', 'b', 'c', 'd', 'e'), 3) == List('c', 'd', 'e', 'a', 'b'))
    assert(DaySixteen.spin(List('a', 'b', 'c', 'd', 'e'), 1) == List('e', 'a', 'b', 'c', 'd'))
  }

  "exchange" should "exchange the programs in positions a and b" in {
    assert(DaySixteen.exchange(List('e', 'a', 'b', 'c', 'd'), 3, 4) == List('e', 'a', 'b', 'd', 'c'))
  }

  "partner" should "should swap the positions of programs a and b" in {
    assert(DaySixteen.partner(List('e', 'a', 'b', 'd', 'c'), 'e', 'b') == List('b', 'a', 'e', 'd', 'c'))
  }

  "partOne" should "return the order of the programs after the dance" in {
    val programs = List('a', 'b', 'c', 'd', 'e')
    val moves = "s1,x3/4,pe/b"
    assert(DaySixteen.partOne(moves, programs) == "baedc")
  }
}
