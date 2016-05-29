class Rational(x: Int, y: Int) {
  require(y > 0, "denominator must be positive")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)

  def add(r: Rational): Rational =
    new Rational(numer * r.denom + r.numer * denom,
      denom * r.denom)

  def neg: Rational = new Rational(-numer, denom)

  def sub(r: Rational): Rational = add(r.neg)

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (less(that)) that else this

  override def toString = numer + "/" + denom
}

val x = new Rational(1, 2)
val y = new Rational(2, 4)
new Rational(2)