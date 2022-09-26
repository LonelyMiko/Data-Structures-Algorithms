package section9

class Queue {
  var array: Array[Int] = Array()

  def peek: Int = array(0)

  def enqueue(value:Int): Unit = array = array.appended(value)

  def dequeue: Unit = array = array.tail

  override def toString: String = array.mkString("Queue(", ",", ")")

  def isEmpty: Boolean = array.isEmpty
}

object Queue {
  def main(args: Array[String]): Unit = {
    val queue = new Queue
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    println(queue)

    queue.dequeue
  }
}
