package my.homework

import org.scalatest._
import org.scalatest.concurrent.ScalaFutures

/**
  * Base trait for unit test specifications.
  */
class AbstractUnitSpec extends Suite
  with WordSpecLike
  with MustMatchers
  with BeforeAndAfterAll
  with OptionValues
  with ScalaFutures
