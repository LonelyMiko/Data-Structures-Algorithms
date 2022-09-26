package section12

import scala.annotation.tailrec

class Factorial {
    def findFactorialRec(number:Int):Int = {
      @tailrec
      def tailRec(number: Int, acc:Int = 1):Int = {
        if (number <= 1) acc
        else tailRec(number-1, acc*number)
      }
      tailRec(number)
    }

  def findFactorialLoop(number: Int): Int = {
    var res = 1
    for (i <- 1 to number){
      res*= i
    }
    res
  }
}

object Factorial {
  def main(args: Array[String]): Unit = {
    val factorial = new Factorial
    println(factorial.findFactorialRec(5))
    println(factorial.findFactorialLoop(5))
  }
}