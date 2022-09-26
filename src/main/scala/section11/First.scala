package section11

class First {
  //   2 - 0
  // /   \
  //1 - - 3
//Edge List

  private val edgeList = Array(Array(0,2), Array(2,1), Array(2,3), Array(3,2))

  //Adjacency matrix
  private val adjacencyMatrix = Array(
    Array(0,0,1,0), //0
    Array(0,0,1,1), //1
    Array(1,1,0,1), //2
    Array(0,1,1,0)  //3
  )
}
