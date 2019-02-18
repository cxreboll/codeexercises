package my.homework

class MyListSpec extends AbstractUnitSpec {

  "MyListSpec" should {
    "return true for empty lists" in {
      val list = new MyList
      val result = list.contains(List(), List())

      result mustBe(true)
    }
  }

  "MyListSpec" should {
    "return true for source empty and target not empty" in {
      val list = new MyList
      val result = list.contains(List(), List(1))

      result mustBe(true)
    }
  }

  "MyListSpec" should {
    "return false for source non empty and target empty" in {
      val list = new MyList
      val result = list.contains(List("something"), List())

      result mustBe(false)
    }
  }

  "MyListSpec" should {
    "return true for source non empty and target non empty boolean" in {
      val list = new MyList
      val result = list.contains(List(true), List(false, true))

      result mustBe(true)
    }
  }

  "MyListSpec" should {
    "return true for source non empty and target non empty int" in {
      val list = new MyList
      val result = list.contains(List(1, 2, 2, 3), List(1, 2, 2, 3))

      result mustBe(true)
    }
  }

  "MyListSpec" should {
    "return false for source non empty and target non empty string" in {
      val list = new MyList
      val result = list.contains(List("1", "2", "2", "3", "3"), List("1", "2", "2", "3"))

      result mustBe(false)
    }
  }

  "MyListSpec" should {
    "return false for source non empty and target non empty float" in {
      val list = new MyList
      val result = list.contains(List(2.3, 3.3, 3.3, 3.3), List(2.3, 2.3, 3.3, 3.3))

      result mustBe(false)
    }
  }
}
