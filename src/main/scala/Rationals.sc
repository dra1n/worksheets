class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be positive")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)

  def + (r: Rational): Rational =
    new Rational(numer * r.denom + r.numer * denom,
      denom * r.denom)

  def unary_- : Rational = new Rational(-numer, denom)

  def - (r: Rational): Rational = this + -r

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  override def toString = numer + "/" + denom
}

val x = new Rational(1, 2)
val y = new Rational(2, 4)
new Rational(2)

x + y
-x
x - y