package progfun

object TestPure {
  val x = "Hello World"

  val r1 = x.reverse

  val r2 = x.reverse

  def areEqual(): Boolean = (r1 == r2)
}


/**
 * Substitution x -> "Hello World"
 */
object TestPure2 {
  val x = "Hello World"

  val r1 = "Hello World".reverse

  val r2 = "Hello World".reverse

  def areEqual(): Boolean = (r1 == r2)
}


object TestPure3 {
  val x = new StringBuilder("Hello")
  val y = x.append(" World")

  val r1 = y.toString // r1 = "Hello World"
  val r2 = y.toString // r2 = "Hello World"

  def areEqual(): Boolean = (r1 == r2)
}


/**
 * Substitution y -> x.append(" World")
 */
object TestPure4 {
  val x = new StringBuilder("Hello")
  val y = x.append(" World")

  val r1 = x.append(" World").toString // r1 = "Hello World"
  val r2 = x.append(" World").toString // r2 = "Hello World World"

  def areEqual(): Boolean = (r1 == r2)
}
