package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayFifteenSpec extends FlatSpec {

  "intTo32Bit" should "convert an int to a list with its 32 bit binary representation" in {
    assert(DayFifteen.intTo32Bit(1092455) == "00000000000100001010101101100111".split("").toList.map(_.toInt))
    assert(DayFifteen.intTo32Bit(430625591) == "00011001101010101101001100110111".split("").toList.map(_.toInt))
    assert(DayFifteen.intTo32Bit(1181022009) == "01000110011001001111011100111001".split("").toList.map(_.toInt))
    assert(DayFifteen.intTo32Bit(1233683848) == "01001001100010001000010110001000".split("").toList.map(_.toInt))
  }

  "compareBinaryPairs" should "return true if the rightmost 16 bits of the two pairs match" in {
    val p1 = "00000000000100001010101101100111".split("").toList.map(_.toInt)
    val p2 = "00011001101010101101001100110111".split("").toList.map(_.toInt)
    assert(!DayFifteen.compareBinaryPairs(p1, p2))
    val p3 = "00001110101000101110001101001010".split("").toList.map(_.toInt)
    val p4 = "01010101010100101110001101001010".split("").toList.map(_.toInt)
    assert(DayFifteen.compareBinaryPairs(p3, p4))
  }

  "partOne" should "return the number of matches" in {
    assert(DayFifteen.partOne(65, 8921, 16807, 48271, 2147483647, 5) == 1)
  }

  "generateValues" should "generate a list of values for the generators" in {
    assert(DayFifteen.generateValues(65, 16807, 2147483647, 4, 5) == List(
      1352636452:BigInt, 1992081072:BigInt, 530830436:BigInt, 1980017072:BigInt, 740335192:BigInt
    ))
    assert(DayFifteen.generateValues(8921, 48271, 2147483647, 8, 5) == List(
      1233683848:BigInt, 862516352:BigInt, 1159784568:BigInt, 1616057672:BigInt, 412269392:BigInt
    ))
  }

  "partTwo" should "return the number of matches" in {
    assert(DayFifteen.partTwo(65, 8921, 16807, 48271, 4, 8, 2147483647, 5) == 0)
  }
}
