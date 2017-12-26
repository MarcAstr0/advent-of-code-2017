package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayEighteenSpec extends FlatSpec {

  "initRegisters" should "return a Map with the registers all set to zero" in {
    val input =
      """set a 1
        |add a 2
        |mul a a
        |mod a 5
        |snd a
        |set a 0
        |rcv a
        |jgz a -1
        |set a 1
        |jgz a -2""".stripMargin
    assert(DayEighteen.initRegisters(input) == collection.mutable.Map('a' -> 0))
  }

  "partOne" should "return the value of the recovered frequency the first time a rcv instruction is executed with a non-zero value" in {
    val input =
      """set a 1
        |add a 2
        |mul a a
        |mod a 5
        |snd a
        |set a 0
        |rcv a
        |jgz a -1
        |set a 1
        |jgz a -2""".stripMargin
    assert(DayEighteen.partOne(input) == 4)
  }
}
