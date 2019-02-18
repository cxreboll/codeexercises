package my.homework

import scala.math.BigDecimal.RoundingMode


class Triangle(a: BigDecimal, b: BigDecimal, c: BigDecimal, rounding: Int = 5) {

  /**
    * Making sure we have a way to compare those number if they are float.
    * We could pass precision as parameter
    */
  val aSide = a.setScale(rounding, RoundingMode.CEILING)
  val bSide = b.setScale(rounding, RoundingMode.CEILING)
  val cSide = c.setScale(rounding, RoundingMode.CEILING)

  /**
    * We need values sorted for some cases.
    */
  val list = List(aSide, bSide, cSide).sorted

  /**
    * Any side should be bigger than 0
    * @param side
    * @return
    */
  def isSideValid(side: BigDecimal): Boolean = side > 0

  /**
    * Checking all sides are bigger than 0
    * @return
    */
  def isValid: Boolean =  list.foldLeft(true) { (acc, obj) =>
    acc && isSideValid(obj)
  } && triangleInequalityTheorem

  /**
    * A valid triangle if:
    * a + b > c
    * a + c > b
    * c + b > a
    * @return
    */
  def triangleInequalityTheorem: Boolean =  (aSide + bSide) > cSide && (bSide + cSide) > aSide &&
    (cSide + aSide) > bSide

  /**
    * All sides must match
    * @return
    */
  def isEquilateral: Boolean = aSide == bSide && aSide == cSide

  /**
    * 2 sides must be equal.
    * @return
    */
  def isIsosceles: Boolean = {
    val aside = list(0)
    val bside = list(1)
    val cside = list(2)

    // Sorting it means that, the 2 equal sides are located at the end, or start, of the list.
    ((aside == bside) && (bside != cside)) || ((cside == bside) && (aside != cside))
  }

  /**
    * All sides must be different.
    * @return
    */
  def isScalene: Boolean = aSide != bSide && bSide != cSide && cSide != aSide

  /**
    *
    * @return "This Equilateral" if all sides are the same. "This Isosceles" if 2 sides are the same.
    *         "This Scalene" if all sides are different. Or a sentence starting with "Not a triangle!" followed by
    *         a description of the issue.
    */
  def whaTypeIsIt: String = {
    import Triangle._

    if (!isValid) return s"$ERROR All sides must be bigger than 0 a[$a] b[$b] c[$c]"

    (isEquilateral, isIsosceles, isScalene) match {
      case (true, false, false) => EQUILATERAL
      case (false, true, false) => ISOSCELES
      case (false, false, true) => SCALENE
      case _ => s"$ERROR a[$a] b[$b] c[$c]"
    }
  }
}
object Triangle {
  def apply(a: BigDecimal, b: BigDecimal, c: BigDecimal): Triangle = new Triangle(a, b, c)
  def apply(a: BigDecimal, b: BigDecimal, c: BigDecimal,  rounding: Int): Triangle = new Triangle(a, b, c, rounding)

  val EQUILATERAL = "This Equilateral"
  val ISOSCELES = "This Isosceles"
  val SCALENE = "This Scalene"
  val ERROR = "Not a triangle!"
}
