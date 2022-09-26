package section10
import org.scalatest.flatspec.AnyFlatSpec

class MainTest extends AnyFlatSpec {
  it must "print right side of tree" in {
    val tree = new BinarySearchTree[String, Int]()
    tree.insert("abc", 1)
    tree.insert("ab", 2)
    tree.insert("a", 3)
    tree.insert("d", 4)
    tree.insert("e", 5)
    tree.insert("f", 6)
    tree.insert("def", 7)

    println(tree.rightSideOfTree())
  }
}
