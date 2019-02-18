package my.homework

class MyLinkedListSpec extends AbstractUnitSpec {

  "MyLinkedListSpec" should {
    "return fifth element big decimal" in {
      val list = MyLinkedList(0, 1, 2, 3, 4, 5, 6)
      val result = list.getNthFromLast(5)

      result.isDefined mustBe(true)
      result.get.value mustBe(2)
    }
  }

  "MyLinkedListSpec" should {
    "return 3rd element String" in {
      val list = MyLinkedList("hello", "my", "dear", "friends!")
      val result = list.getNthFromLast(3)

      result.isDefined mustBe(true)
      result.get.value mustBe("my")
    }
  }

  "MyLinkedListSpec" should {
    "return None when there is no element" in {
      val list = MyLinkedList(true, true, false, false)
      val result = list.getNthFromLast(10)

      result.isDefined mustBe(false)
    }
  }

  "MyLinkedListSpec" should {
    "return None when linked list is empty" in {
      val list = MyLinkedList()
      val result = list.getNthFromLast(10)

      result.isDefined mustBe(false)
    }
  }
}
