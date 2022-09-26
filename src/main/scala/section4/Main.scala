package section4

object Main {
  def containsCommonItems[T](array1: Array[T], array2: Array[T]) : Boolean = {
    array1.find(elem => array2.contains(elem)) match {
      case Some(_) => true
      case _ => false
    }
  }
}
