package section12

import scala.annotation.tailrec
import scala.collection.mutable

class Fibonacci {
  def findFibonacciRec(num: Int): Int = {
    var array = Array[Int](0,1)
    @tailrec
    def rec(num:Int):Int = {
      if (num == 0) array.last
      else {
        val lastElem = array.last
        val secondElem = Option(array(array.length - 2)).getOrElse(0)
        array =  array.appended(secondElem + lastElem)
        rec(num -1)
      }
    }
    rec(num)
  }
}

object Fibonacci {
  def main(args: Array[String]): Unit = {
    val fib = new Fibonacci()
    println(fib.findFibonacciRec(5))
  }
}
