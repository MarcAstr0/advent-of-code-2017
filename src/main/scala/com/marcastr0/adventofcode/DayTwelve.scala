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

  def partOne(list: String): Int = {
    val programs = list.split("\n").toList map (_.split(" <-> ").toList) map (x => (x.head.toInt, x.tail.head.split(",").toList.map(_.trim.toInt)))
    dfs(0, programs.toMap).length
  }

}
