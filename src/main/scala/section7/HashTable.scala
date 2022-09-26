package section7

import java.util
import scala.collection.mutable


object HashTable {
  def main(args: Array[String]): Unit = {
    val hashTable: mutable.HashMap[String, Int] = mutable.HashMap.empty[String, Int]
    hashTable += ("firstKey" -> 123)

  }
}
