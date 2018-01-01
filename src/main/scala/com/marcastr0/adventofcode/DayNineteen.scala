package com.marcastr0.adventofcode

import scala.collection.mutable.ListBuffer

object DayNineteen {

  def convertRoutingDiagram(routingDiagram: String): List[List[String]] = {
    val diagram = routingDiagram.split("\n").toList.map(_.split("").toList)
    diagram.map(_.padTo(diagram.map(_.length).max, " "))
  }

  def isPathChar(char: String): Boolean = List("|", "-", "+").contains(char)

  def changeDirection(diagram: List[List[String]], position: (Int, Int), current: String): String = {
    diagram(position._1)(position._2) match {
      case "+" =>
        current match {
          case "down" | "up" =>
            if (diagram(position._1).lift(position._2 + 1).getOrElse(" ") != " ") "right"
            else if (diagram(position._1).lift(position._2 - 1).getOrElse(" ") != " ") "left"
            else current
          case "left" | "right" =>
            if (diagram(position._1 - 1).lift(position._2).getOrElse(" ") != " ") "up"
            else if (diagram(position._1 + 1).lift(position._2).getOrElse(" ") != " ") "down"
            else current
        }
      case _ => current
    }
  }

  def partOne(routingDiagram: String): String = {
    val diagram = convertRoutingDiagram(routingDiagram)
    var direction = "down"
    var position = (0, diagram.head.indexOf("|"))
    val path = collection.mutable.ListBuffer[String]()
    while(diagram(position._1)(position._2) != " ") {
      direction match {
        case "down" => position = (position._1 + 1, position._2)
        case "left" => position = (position._1, position._2 - 1)
        case "right" => position = (position._1, position._2 + 1)
        case "up" => position = (position._1 - 1, position._2)
      }
      if (!isPathChar(diagram(position._1)(position._2)) && diagram(position._1)(position._2) != " ") {
        path += diagram(position._1)(position._2)
      }
      else {
        direction = changeDirection(diagram, position, direction)
      }
    }
    path.mkString
  }

  def partTwo(routingDiagram: String): Int = {
    val diagram = convertRoutingDiagram(routingDiagram)
    var direction = "down"
    var position = (0, diagram.head.indexOf("|"))
    var steps = 0
    while(diagram(position._1)(position._2) != " ") {
      direction match {
        case "down" => position = (position._1 + 1, position._2)
        case "left" => position = (position._1, position._2 - 1)
        case "right" => position = (position._1, position._2 + 1)
        case "up" => position = (position._1 - 1, position._2)
      }
      if (!isPathChar(diagram(position._1)(position._2)) && diagram(position._1)(position._2) != " ") {
        steps += 1
      }
      else {
        steps += 1
        direction = changeDirection(diagram, position, direction)
      }
    }
    steps
  }
}
