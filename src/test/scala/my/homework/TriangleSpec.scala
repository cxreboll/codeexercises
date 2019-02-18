package my.homework

class TriangleSpec extends AbstractUnitSpec {

  "TriangleSpec" should {
    "return Equilateral for Int values" in {
      val triangle = Triangle(5, 5, 5)
      val isTest = triangle.isEquilateral
      val isText = triangle.whaTypeIsIt

      isText mustBe(Triangle.EQUILATERAL)
      isTest mustBe(true)
    }
  }

  "TriangleSpec" should {
    "return Isosceles for Int values" in {
      val triangle = Triangle(5, 5, 1)
      val isTest = triangle.isIsosceles
      val isText = triangle.whaTypeIsIt

      isText mustBe(Triangle.ISOSCELES)
      isTest mustBe(true)
    }
  }

  "TriangleSpec" should {
    "return Scalene for Int values" in {
      val triangle = Triangle(5, 3, 4)
      val isTest = triangle.isScalene
      val isText = triangle.whaTypeIsIt

      isText mustBe(Triangle.SCALENE)
      isTest mustBe(true)
    }
  }

  "TriangleSpec" should {
    "return Equilateral for Float values" in {
      val triangle = Triangle(5.333, 5.333, 5.333)
      val isTest = triangle.isEquilateral
      val isText = triangle.whaTypeIsIt

      isText mustBe(Triangle.EQUILATERAL)
      isTest mustBe(true)
    }
  }

  "TriangleSpec" should {
    "return Isosceles for Float values" in {
      val triangle = Triangle(5.333, 5.333, 6.222)
      val isTest = triangle.isIsosceles
      val isText = triangle.whaTypeIsIt

      isText mustBe(Triangle.ISOSCELES)
      isTest mustBe(true)
    }
  }

  "TriangleSpec" should {
    "round appropriately values" in {
      val triangle = Triangle(5.333999, 5.333888, 6.222211, 3)
      val isText = triangle.whaTypeIsIt

      isText mustBe(Triangle.ISOSCELES)
    }
  }

  "TriangleSpec" should {
    "return Not a triangle for 0 values" in {
      val triangle = Triangle(0, 5.333, 6.222)
      val isText = triangle.whaTypeIsIt

      isText.startsWith(Triangle.ERROR) mustBe(true)
    }
  }
}
