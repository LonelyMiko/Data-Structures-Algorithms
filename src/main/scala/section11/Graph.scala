package section11

import scala.collection.mutable
import scala.reflect.ClassTag

class Graph[T](implicit classTag: ClassTag[T]) {
  def length: Int = adjacencyList.size

  private val adjacencyList: mutable.Map[T, Array[T]] = mutable.Map[T, Array[T]]()

  def addVertex(node:T): Unit = {
      if (!adjacencyList.contains(node)){
        adjacencyList += (node -> Array.empty[T])
      }
  }

  def addEdge(firstNode:T, secondNode:T): Unit = {
    val arrayFirstNode = adjacencyList.getOrElse(firstNode, Array.empty[T])
    adjacencyList.update(firstNode,arrayFirstNode.appended(secondNode))
    val arraySecondNode = adjacencyList.getOrElse(secondNode, Array.empty[T])
    adjacencyList.update(secondNode,arraySecondNode.appended(firstNode))
  }

  def showConnections(): Unit = {
    adjacencyList.foreach (elem => {
    println (s"${elem._1} --> ${elem._2.mkString (", ")}")
  })
  }
}

object Graph {
  def main(args: Array[String]): Unit = {
    val graph = new Graph[Int]
    graph.addVertex(0)
    graph.addVertex(1)
    graph.addVertex(2)
    graph.addVertex(3)
    graph.addVertex(4)
    graph.addVertex(5)
    graph.addVertex(6)

    graph.addEdge(3, 1)
    graph.addEdge(3, 4)
    graph.addEdge(4, 2)
    graph.addEdge(4, 5)
    graph.addEdge(1, 2)
    graph.addEdge(1, 0)
    graph.addEdge(0, 2)
    graph.addEdge(6, 5)

    graph.showConnections()
  }
}
