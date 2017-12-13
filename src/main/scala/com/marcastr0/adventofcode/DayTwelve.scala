package com.marcastr0.adventofcode

object DayTwelve {

  /*
   * Depth-first Search, adapted from https://codereview.stackexchange.com/questions/29699/bfs-and-dfs-in-scala
   */
  def dfs(start: Int, graph: Map[Int, List[Int]]): List[Int] = {

    def dfsRec(vertex: Int, visited: List[Int]): List[Int] = {
      if (visited.contains(vertex))
        visited
      else {
        val neighbors: List[Int] = graph(vertex) filterNot visited.contains
        neighbors.foldLeft(vertex :: visited)((b, a) => dfsRec(a, b))
      }
    }
    dfsRec(start, List()).reverse
  }

  def stringToGraph(input: String): Map[Int, List[Int]] = {
    input.split("\n").toList.
      map (_.split(" <-> ").toList).
      map (x => (x.head.toInt, x.tail.head.split(",").toList.
        map(_.trim.toInt))).toMap
  }

  def partOne(list: String): Int = {
    val graph = stringToGraph(list)
    dfs(0, graph).length
  }

  def partTwo(list: String): Int = {
    val graph = stringToGraph(list)
    var groups = collection.mutable.ListBuffer[List[Int]]()
    val allPrograms = graph.keys.toList
    var i = 0
    while (groups.flatten.length < allPrograms.length) {
      while (groups.flatten.contains(allPrograms(i))) i += 1
      groups += dfs(allPrograms(i), graph)
    }
    groups.length
  }
}
