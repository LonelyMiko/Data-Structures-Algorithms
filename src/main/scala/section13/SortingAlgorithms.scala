package section13

import scala.collection.mutable
import scala.util.Random

case class SortingAlgorithms() {
  def bubbleSort(list: mutable.Seq[Int]): Seq[Int] = {
    println(s"List before sort: ${list.mkString(",")}")
    for (i <- 0 until list.size - 1) {
      if (list(i) > list(i+1)) {
        val tmp = list(i)
        list(i) = list(i+1)
        list(i+1) = tmp
      }
    }
    println(s"List after sort: ${list.mkString(",")}")
    list.toSeq
  }

  def selectionSort(list: mutable.Seq[Int]): Seq[Int] = {
    println(s"List before sort: ${list.mkString(",")}")
    for (i <- 0 until list.size - 1) {
      var minIndex = i
      val temp = list(i)
      for (j <- i + 1 until list.size) {
        if (list(j) < list(minIndex)) {
          minIndex = j
        }
      }
      list(i) = list(minIndex)
      list(minIndex) = temp
    }
    println(s"List after sort: ${list.mkString(",")}")
    list.toSeq

    }

  def insertionSort(list: mutable.Seq[Int]): Seq[Int] = {
    prettyPrint("Insertion Sort")
    println(s"List before sort: ${list.mkString(",")}")
    for (i <- list.indices){
      val key = list(i)
      var j = i - 1
      while (j >= 0 && list(j) > key){
        list(j + 1) = list(j)
        j = j -1
      }
      list(j + 1) = key
    }
    println(s"List after sort: ${list.mkString(",")}")
    list.toSeq
  }

  def prettyPrint(text: String): Unit = {
    val size = 30
    val left = (size - text.length) / 2
    val right = size - left - text.length
    val repeatedChar = "-"
    val buff = new StringBuffer()
    for (_ <- 0 until left) {
      buff.append(repeatedChar)
    }
    buff.append(s" $text ")
    for (_ <- 0 until right) {
      buff.append(repeatedChar)
    }
    println(buff.toString)
  }

  def mergeSort(list: mutable.Seq[Int]): Seq[Int] = {
    prettyPrint("Merge Sort")
    println(s"List before sort: ${list.mkString(",")}")
    def sort(list: mutable.Seq[Int]): Seq[Int] = {
      MS(list, 0, list.length - 1)
    }

    def MS(list: mutable.Seq[Int], low: Int, high: Int): Seq[Int] = {
      if (low < high){
        val mid: Int = (low + high) / 2
        MS(list, low, mid)
        MS(list, mid + 1, high)
        merge(list, low, mid, high)
      } else {
        list.toSeq
      }
    }

    def merge(list: mutable.Seq[Int], low: Int, mid: Int, high: Int): Seq[Int] = {
      val left = list.slice(low, mid + 1)
      val right = list.slice(mid + 1 , high + 1)
      var i = 0
      var j = 0
      var k = low

      while (k < high + 1){
        if (i > left.length - 1){
          list(k) = right(j)
          j += 1
        } else if (j > right.length - 1){
          list(k) = left(i)
          i += 1
        } else if (left(i) <= right(j)){
          list(k) = left(i)
          i += 1
        } else {
          list(k) = right(j)
          j += 1
        }
        k += 1
      }
      list.toSeq
    }
    sort(list)
  }

}

object SortingAlgorithms{
  def main(args: Array[String]): Unit = {
    val list = mutable.ListBuffer(2,1,3)
    SortingAlgorithms().bubbleSort(list)
    val list1 = mutable.ListBuffer(12,22,11)
    SortingAlgorithms().insertionSort(list1)
    SortingAlgorithms().insertionSort(generateSeq(1000))
    println(SortingAlgorithms().mergeSort(generateSeq(25)))

    val randomSeq = generateSeq(50)
    randomSeq.sortWith((elem1, elem2) => elem1 < elem2)

    val listOfTuples = List(
      Tuple2(1,"c"),
      Tuple2(2,"b"),
      Tuple2(3,"a")
    )
    listOfTuples.sortBy(_._2)
  }

  private def generateSeq(size: Int): mutable.Seq[Int] = {
    val rand = Random
    mutable.Seq.fill(size)(rand.nextInt(size))
  }
}
