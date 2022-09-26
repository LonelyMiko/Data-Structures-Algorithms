package section9

import scala.collection.mutable
import scala.util.Random

object StackObj {
  def main(args: Array[String]): Unit = {
    val stack = mutable.Stack[Int]()
    stack.pushAll(Seq(8, 7, 9, 10, 2))
    println(stack)
  }
}
