package my.homework

import scala.collection.mutable

class MyList {

  /**
    * Compare source against target
    * @param source
    * @param target
    * @tparam T
    * @return Return true if source is empty regardless of target. False if all elements in source are not contained
    *         in target, or True if all source elements are contained in target.
    */
  def contains[T](source:List[T], target: List[T]): Boolean = {
    if (source.isEmpty) { // empty source returns true.
      true
    } else if (source.size > target.size) { // larger source means it is not contained by target.
      false
    } else {
      // Putting target in a map, and counting the number of hits per element
      val map = new mutable.HashMap[T, Int]()
      for (element <- target)  {
        val hit = map.get(element)
        if (hit.isDefined) {
          val counter = hit.get
          map.put(element, counter + 1)
        } else {
          map.put(element, 1)
        }
      }

      // Traversing source, if element doesn't exist, or the cardinality of element is larger in source than in target
      // then returning false
      for (element <- source) {
        val hit = map.get(element)
        if (hit.isEmpty) {
          return false
        } else if (hit.isDefined) {
          val counter = hit.get
          if (counter <= 0) {
            return false
          } else {
            map.put(element, counter - 1)
          }
        }
      }

      // If we got here then means that target contains source
      true
    }
  }

}
