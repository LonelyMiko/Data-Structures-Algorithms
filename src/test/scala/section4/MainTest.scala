package section4
import org.scalatest.flatspec.AnyFlatSpec
import section4.Main.containsCommonItems
import org.apache.logging.log4j.scala.Logging

class MainTest extends AnyFlatSpec {
  "commonItems" must "return true if two arrays have common items" in {
    info("Testing if commonItem return true if array have two commonElements")
    val array1 = Array("1", "2", "3", "4", "5")
    val array2 = Array("5", "6", "7")
    assert(containsCommonItems(array1, array2))
  }

  "commonItems" must "return false if array don't have two common elements" in {
    info("Testing if commonItem return false if array don't have two commonElements")
    val array1 = Array("1", "2", "3")
    val array2 = Array("5", "6", "7")
    assert(!containsCommonItems(array1, array2))
  }

  "commonItems" must "return true for generic types" in {
    info("Testing if commonItem return true for generic types")
    val stringArray1 = Array("hi", "hello", "bonjour")
    val stringArray2 = Array("salut","ciao","hi")
    val intArray1 = Array(1,2,3)
    val intArray2 = Array(3,4,5)
    assert(containsCommonItems[String](stringArray2,stringArray1) && containsCommonItems[Int](intArray1, intArray2))
  }
}
