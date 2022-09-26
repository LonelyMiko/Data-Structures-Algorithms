package section8

import java.util
object Main {
  def main(args: Array[String]): Unit = {
   val linkedList = new util.LinkedList[String]()
   //push using stack method, FILO
    linkedList.push("first")
    linkedList.push("second")
    linkedList.push("third")

    //The same methods what get the first element in list
    println(linkedList.element())
    println(linkedList.getFirst)
    println(linkedList.peek())

    //Retrieves and removes the head (first element) of this list.
    println(linkedList.poll())
    println(linkedList.pop())
    println(linkedList.removeFirst())


  }
}
