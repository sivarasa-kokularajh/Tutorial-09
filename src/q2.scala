class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero.")

  private val gcdVal = gcd(n.abs, d.abs)
  val numerator: Int = n / gcdVal
  val denominator: Int = d / gcdVal

  def sub(other: Rational): Rational = {
    new Rational(
      numerator * other.denominator - other.numerator * denominator,
      denominator * other.denominator
    )
  }

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString: String = s"$numerator/$denominator"
}

object RationalSubtractionExample {
  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val xyMinusZ = x.sub(y).sub(z)

    println(s"The result of xy - z is: $xyMinusZ") // Output: The result of xy - z is: -85/56
  }
}
