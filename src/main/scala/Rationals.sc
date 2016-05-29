class Rational(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def numer = x / gcd(x, y)
  def denom = y / gcd(x, y)

  def add(r: Rational): Rational =
    new Rational(numer * r.denom + r.numer * denom,
      denom * r.denom)

  def neg: Rational = new Rational(-numer, denom)

  def sub(r: Rational): Rational = add(r.neg)

  override def toString = numer + "/" + denom
}

val x = new Rational(1, 2)
val y = new Rational(2, 4)