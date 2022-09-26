package section6

import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag._

//https://docs.scala-lang.org/overviews/collections-2.13/performance-characteristics.html
object Main {
  def main(args: Array[String]): Unit = {
    val array: ArrayBuffer[String] = ArrayBuffer("a", "b", "c")
    array.append("t") // aC
    array.head
    array.tail
    array.prepend("tt")
    array.update(2, "ab")
    println(array.foldLeft("Res: ")((elm1, elm2) => elm1 + " elem1 " + elm2 + " elem2 "))
    println(array)
    println(reverseString("NnN123"))
    println(mergedSortedArrays(Array(3, 4, 5), Array(1, 2, 3)).mkString("Array(", ", ", ")"))
  }

  def reverseString(string: String): String = {
      val charSequence = string.split("")
      val backwards = ArrayBuffer[String]()
      for (i <- charSequence.length - 1 to 0 by -1) {
        backwards.append(charSequence(i))
      }
    backwards.mkString
  }

  def mergedSortedArrays(array1: Array[Int], array2: Array[Int]): Array[Int] = {
    val mergedArray = array1.concat(array2)
    mergedArray.sorted  
  }
}
