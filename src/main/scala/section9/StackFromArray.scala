package section9

import scala.reflect.ClassTag

final class StackFromArray[T](elem: T)(implicit classTag: ClassTag[T]) {
  private var array: Array[T] = Array[T](elem)
  def peek: Option[T] = array.length match {
    case 0 => None
    case _ => Some(array.head)
  }

  def push(value: T): Unit = {
    array = array.prepended(value)
  }
  def mkString : String = array.mkString("StackFromArray(", ", ", ")")

  def pop: Option[T] = {
    array.length match {
      case 0 => None
      case _ =>
        val elem = array(0)
        array = array.tail
        Some(elem)
    }
  }

  def addAll[C <: Seq[T]](list: C): Unit = {
    for (i <- list.indices){
      array = array.prepended(list(i))
    }
  }

  def removeAll(): Unit = {
    array = Array.empty[T]
  }

  def contains(elem: T): Boolean = array.contains(elem)

  def length: Int = array.length
}

object StackFromArray {

  def main(args: Array[String]): Unit = {
    val stackFromArray = new StackFromArray[Int](1)
    stackFromArray.push(2)
    stackFromArray.push(3)
    println(stackFromArray.mkString)
    println(stackFromArray.contains(2))
    println(stackFromArray.pop)
    println(stackFromArray.mkString)
    println(stackFromArray.removeAll())
  }
}
