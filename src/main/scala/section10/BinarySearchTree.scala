package section10

import java.util
import scala.annotation.tailrec

class BinarySearchTree[K, V](implicit ordering: Ordering[K]) {
  private sealed trait Tree[K, V]
  private case object Leaf extends Tree[K, V]
  private case class Branch[K, V](
                                   left: Tree[K,V],
                                   right: Tree[K,V],
                                   key: K,
                                   value: V
                                 ) extends Tree[K, V]
  private var root: Tree[K,V] = Leaf


  def find(k: K): Option[V] = {
    find(root, k)
  }

  def insert[A](k: K, v: V): Unit = {
    this.root = insert(root, k, v);
  }

  def size(): Int = {
    size(this.root)
  }

  def min(): Option[V] = {
    min(this.root)
  }

  def max(): Option[V] = {
    max(this.root)
  }

  def rightSideOfTree(): List[V] = {
    rightSideOfTree(this.root)
  }

  def leftSideOfTree():List[V] = {
    leftSideOfTree(this.root)
  }


  @tailrec
  private def find(tree: Tree[K,V], element:K): Option[V] ={
    tree match {
      case Leaf => None
      case Branch(left, right, key, value) =>
        if (ordering.equiv(key, element)) Some(value)
        else if (ordering.lt(element, key)) find(left, key)
        else find(right, key)
    }
  }

  private def insert(tree: Tree[K, V], key: K, value: V): Tree[K, V] = tree match {
    case Leaf => Branch(Leaf, Leaf, key, value)
    case Branch(left, right, k, v) if ordering.equiv(k,key) => Branch(left, right, k, v)
    case Branch(left, right, k, v) if ordering.lt(key,k) => Branch(insert(left, key, value), right, k, v)
    case Branch(left, right, k, v) => Branch(left, insert(right, key, value), k, v)
  }

  private def size(tree: Tree[K, V]): Int = tree match {
    case Leaf => 0
    case Branch(left, right, _, _) => 1 + size(left) + size(right)
  }

  @tailrec
  private def min(tree: Tree[K, V]): Option[V] = tree match {
    case Leaf => None
    case Branch(left, _, _, value) => left match {
      case Leaf => Some(value)
      case Branch(left, _, _, _) => min(left)
    }
  }

  @tailrec
  private def max(tree: Tree[K,V]): Option[V] = tree match {
    case Leaf => None
    case Branch(_, right, _, value) => right match {
      case Leaf => Some(value)
      case Branch(_, right, _,_) => max(right)
    }
  }

  @tailrec
  private def rightSideOfTree(tree: Tree[K,V], acc: List[V] = List()): List[V] = tree match {
    case Leaf => acc
    case Branch(_, right, _, value) => right match {
      case Leaf => acc.appended(value)
      case Branch(_, right, _, value) => rightSideOfTree(right, acc.appended(value))
    }
  }

  @tailrec
  private def leftSideOfTree(tree: Tree[K,V], acc: List[V] = List()):List[V] = tree match {
    case Leaf => acc
    case Branch(left, _, _, value) => left match {
      case Leaf => acc.appended(value)
      case Branch(left, _, _, value) => leftSideOfTree(left, acc.appended(value))
    }
  }
}
