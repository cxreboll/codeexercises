package my.homework

/**
  * A generic Node class
  * @param value
  * @param next
  * @tparam T
  */
case class Node[T](value: T, next: Option[Node[T]] = None)

class MyLinkedList[T](values: Seq[T]) {
  // Dummy value to start folding
  private val empty = Option.empty[Node[T]]
  // Fold right to build our linked list
  private val linked = values.foldRight(empty)((obj, acc) => {
    Some(Node(obj, acc))
  })

  /**
    * Get the nth value from last.
    * @param nth
    * @return
    */
  def getNthFromLast(nth: Int): Option[Node[T]] = {
    var position = nth * -1
    var head = linked
    val queue = new collection.mutable.Queue[Option[Node[T]]]()
    while (head.isDefined) {
      // More than n elements are in the queue, removing the first element from the queue
      if (position > -1) {
        queue.dequeue()
      }
      queue.enqueue(head)
      head = head.get.next
      position = position + 1
    }

    // position 0 or more, means that list has more elements than nth
    if (position > -1) {
      queue.front
    } else {
      None
    }
  }
}

object MyLinkedList {
  def apply[T](values: T*): MyLinkedList[T] = new MyLinkedList(values)
}
