package com.marcastr0.adventofcode

import scala.annotation.tailrec

object DayTwentyOne {
  type Image = List[List[Char]]

  def stringToImage(image: String): Image = image.split("\n").toList map (_.split("").toList.map(_.head))

  def rotateImage(image: Image): Image = {
    image.head.indices.map(i => image.map(_(i))).map(_.reverse).toList
  }

  def flipHorizontal(image: Image): Image = image map (_.reverse)

  def flipVertical(image: Image): Image = image.reverse

  def matchesRule(rule: String, image: Image): Boolean = {
    val rulePattern: Image = rule.split("/").toList map (_.split("").toList.map(_.head))
    val flippedH = flipHorizontal(image)
    val flippedV = flipVertical(image)

    if (image == rulePattern ||
      rotateImage(image) == rulePattern ||
      rotateImage(rotateImage(image)) == rulePattern ||
      rotateImage(rotateImage(rotateImage(image))) == rulePattern ||
      flippedH == rulePattern ||
      rotateImage(flippedH) == rulePattern ||
      rotateImage(rotateImage(flippedH)) == rulePattern ||
      rotateImage(rotateImage(rotateImage(flippedH))) == rulePattern ||
      flippedV == rulePattern ||
      rotateImage(flippedV) == rulePattern ||
      rotateImage(rotateImage(flippedV)) == rulePattern ||
      rotateImage(rotateImage(rotateImage(flippedV))) == rulePattern
    ) true
    else false
  }

  def divideImage(image: Image, divisor: Int): List[Image] = {
    divisor match {
      case 2 => {
        for {
          i <- 0 until image.length - 1 by 2
          j <- 0 until image.length - 1 by 2
        } yield List(List(image(i)(j), image(i)(j+1)), List(image(i+1)(j), image(i+1)(j+1)))
      }.toList
      case 3 => {
        for {
          i <- 0 until image.length - 2 by 3
          j <- 0 until image.length - 2 by 3
        } yield List(
          List(image(i)(j), image(i)(j+1), image(i)(j+2)),
          List(image(i+1)(j), image(i+1)(j+1), image(i+1)(j+2)),
          List(image(i+2)(j), image(i+2)(j+1), image(i+2)(j+2))
        )
      }.toList
    }
  }

  def enhanceImage(rules: List[String], image: Image): Image = {
    val divided = if (image.length % 2 == 0) divideImage(image, 2) else divideImage(image, 3)
    val enhanced = divided map {i =>
      val matchingRule = rules.filter(r => matchesRule(r.split(" => ").head, i))
      if (matchingRule.nonEmpty)
        matchingRule.head.split(" => ").tail.head.split("/").toList map (_.split("").toList.map(_.head))
      else i
    }
    val enhancedImage = if (enhanced.length == 1) enhanced.head else {
      for {
        i <- 0 until enhanced.length - 1 by Math.sqrt(enhanced.length).toInt
      } yield enhanced.slice(i, i + Math.sqrt(enhanced.length).toInt).transpose.map(_.flatten)
    }.toList.flatten
    enhancedImage
  }

  def partOne(rules: List[String], iterations: Int, image: String): Int = {

    @tailrec
    def partOneRec(rules: List[String], iteration: Int, image: Image): Image = {
      if (iteration == 0) image
      else partOneRec(rules, iteration - 1, enhanceImage(rules, image))
    }

    partOneRec(rules, iterations, stringToImage(image)).flatten.count(_ == '#')
  }
}
