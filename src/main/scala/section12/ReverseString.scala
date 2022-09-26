package section12

import scala.annotation.tailrec

class ReverseString {
    def reverseString(string: String) : String = {
      @tailrec
      def reverseStringTailRec(string: String, acc:String = ""): String ={
        if (string.isBlank) acc
        else reverseStringTailRec(string.substring(0, string.length - 1), acc.appended(string.last))
      }
      reverseStringTailRec(string)
    }
}

object ReverseString {
  def main(args: Array[String]): Unit = {
    val string = new ReverseString()
    println(string.reverseString("test"))
  }
}