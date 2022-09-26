package section14

import scala.annotation.tailrec

object SearchAlgorithms {
  def main(args: Array[String]): Unit = {
    val seq = Seq(1,2,3,4)
    println(linearSearch[Int](seq, 4))
    println(binarySearch[Int](seq, -666))
  }

  def linearSearch[T](seq: Seq[T], item: T): Int = {
      for (i <- seq.indices) {
        if (seq(i).equals(item)){
          return i
        }
      }
    -1
  }

  def binarySearch[T](sortedSeq: Seq[T], item: T)(implicit ordering: Ordering[T]): Int = {
    @tailrec
    def rec(sortedSeq: Seq[T], item: T,
            low: Int = 0, high: Int = sortedSeq.length): Int = {
      //Find the middle index
      val middle = low + (high - low) / 2
      if (low > high){
        return -1
      } else if (sortedSeq(middle).equals(item)){
        return middle
      }
      // item > sortedSeq(middle)
      if (ordering.gt(item, sortedSeq(middle))) {
        rec(sortedSeq, item, middle + 1, high)
      } else {
        // sortedSeq(middle) > item
        rec(sortedSeq, item, low, middle - 1)
      }
    }
    rec(sortedSeq, item)
  }
}
