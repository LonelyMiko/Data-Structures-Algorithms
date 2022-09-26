package section10

import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val tree = new BinarySearchTree[Int, Int]()
    for (_ <- 0 until 20) {
      val num = Random.nextInt(50)
      tree.insert(num,num)
    }
    println(tree.size())
    println(tree.rightSideOfTree())
    println(tree.leftSideOfTree())
  }
}
