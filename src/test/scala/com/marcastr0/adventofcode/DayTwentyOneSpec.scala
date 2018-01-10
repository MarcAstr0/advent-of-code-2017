package com.marcastr0.adventofcode

import org.scalatest.FlatSpec

class DayTwentyOneSpec extends FlatSpec {

  "rotateImage" should "rotate the image 90 degrees clockwise" in {
    val original = List(List('.', '#', '.'), List('.', '.', '#'), List('#', '#', '#'))
    val rotated = List(List('#', '.', '.'), List('#', '.', '#'), List('#', '#', '.'))
    assert(DayTwentyOne.rotateImage(original) == rotated)
  }

  "flipHorizontal" should "flip the image horizontally" in {
    val original = List(List('.', '#', '.'), List('.', '.', '#'), List('#', '#', '#'))
    val flipped = List(List('.', '#', '.'), List('#', '.', '.'), List('#', '#', '#'))
    assert(DayTwentyOne.flipHorizontal(original) == flipped)
  }

  "flipVertical" should "flip the image vertically" in {
    val original = List(List('.', '#', '.'), List('.', '.', '#'), List('#', '#', '#'))
    val flipped = List(List('#', '#', '#'), List('.', '.', '#'), List('.', '#', '.'))
    assert(DayTwentyOne.flipVertical(original) == flipped)
  }

  "matchesRule" should "return true if a pattern matches a rule" in {
    val input1 =
      """.#.
        |..#
        |###""".stripMargin
    val input2 =
      """#.
        |..""".stripMargin
    val input3 =
      """.#
        |..""".stripMargin
    val input4 =
      """..
        |.#""".stripMargin
    val input5 =
      """..
        |#.""".stripMargin
    assert(DayTwentyOne.matchesRule(".#./..#/###", DayTwentyOne.stringToImage(input1)))
    assert(DayTwentyOne.matchesRule("../.#", DayTwentyOne.stringToImage(input2)))
    assert(DayTwentyOne.matchesRule("../.#", DayTwentyOne.stringToImage(input3)))
    assert(DayTwentyOne.matchesRule("../.#", DayTwentyOne.stringToImage(input4)))
    assert(DayTwentyOne.matchesRule("../.#", DayTwentyOne.stringToImage(input5)))
  }

  "divideImage" should "divide the image into 2x2 or 3x3 smaller squares" in {
    val fourByFour = List(List('#', '.', '.', '#'), List('.', '.', '.', '.'), List('.', '.', '.', '.'), List('#', '.', '.', '#'))
    val divided4x4 = List(
      List(List('#', '.'), List('.', '.')),
      List(List('.', '#'), List('.', '.')),
      List(List('.', '.'), List('#', '.')),
      List(List('.', '.'), List('.', '#'))
    )
    assert(DayTwentyOne.divideImage(fourByFour, 2) == divided4x4)
    val threeByThree = List(List('.', '#', '.'), List('.', '.', '#'), List('#', '#', '#'))
    assert(DayTwentyOne.divideImage(threeByThree, 3) == List(threeByThree))
  }

  "enhanceImage" should "apply the enhancement rules if they apply" in {
    val rules = List("../.# => ##./#../...", ".#./..#/### => #..#/..../..../#..#")
    val original =
      """#..#
        |....
        |....
        |#..#""".stripMargin
    val enhanced =
      """##.##.
        |#..#..
        |......
        |##.##.
        |#..#..
        |......""".stripMargin
    assert(DayTwentyOne.enhanceImage(rules, DayTwentyOne.stringToImage(original))
      == DayTwentyOne.stringToImage(enhanced))
  }

  "partOne" should "count the number of pixels that stay on after some iterations" in {
    val image =
      """.#.
        |..#
        |###""".stripMargin
    val rules = List("../.# => ##./#../...", ".#./..#/### => #..#/..../..../#..#")
    assert(DayTwentyOne.partOne(rules, 2, image) == 12)
  }
}
