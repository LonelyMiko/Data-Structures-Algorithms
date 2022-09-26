package section9

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.{BeforeAndAfterEach, GivenWhenThen}

class MainTest extends AnyFlatSpec
  with GivenWhenThen
  with BeforeAndAfterEach {

  var stackFromArray: StackFromArray[String] = null
  override def beforeEach: Unit = {
    stackFromArray = new StackFromArray[String]("first")
    super.beforeEach()
  }

  "peek" must "return first element in stack" in {
    stackFromArray.push("test")

    val target = "test"
    val actual = stackFromArray.peek.get
    assert(actual == target)
  }

  "peek" must "return None if the stack is empty" in {
    stackFromArray.removeAll()
    val target = None
    val actual = stackFromArray.peek

    assert(stackFromArray.length == 0)
    assert(actual == target)
  }

  "push" must "add element in front of stack" in {
    stackFromArray.push("test")
    val target = "test"
    val actual = stackFromArray.peek.get
    assert(actual == target)
  }

  "pop" must "remove and return first element in stack" in {
    val target = "first"
    val actual = stackFromArray.pop.get
    assert(actual == target)
  }

  "peek" must "remove and return None if the stack is empty" in {
    stackFromArray.removeAll()
    val target = None
    val actual = stackFromArray.pop

    assert(stackFromArray.length == 0)
    assert(actual == target)
  }

  "addAll" must "add elements in front of stack" in {
    val list = List("a", "b", "c")
    stackFromArray.removeAll()
    stackFromArray.addAll(list)

    for (i <- 0 until 3) {
      val actual = stackFromArray.peek.get
      val target = list(2 - i)
      stackFromArray.pop
      assert(actual == target)
    }
  }

  "removeAll" must  "remove all elements" in {
      stackFromArray.removeAll()
      assert(stackFromArray.length == 0)
    }

  "contains" must "find and element" in {
    assert(stackFromArray.contains("first"))
    assert(!stackFromArray.contains("elem"))
  }

}
