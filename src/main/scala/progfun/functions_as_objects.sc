// An anonymous function such as

(x: Int) => x * x

// is expanded to:

{ class AnonFun extends Function1[Int, Int] {
  def apply(x: Int) = x * x
}
  new AnonFun
}

// or, shorter, using anonymous class syntax:

new Function1[Int, Int] {
  def apply(x: Int) = x * x
}

// So the OO-translation of

val f1 = (x: Int) => x * x

// would be

val f = new Function1[Int, Int] {
  def apply(x: Int) = x * x
}

f.apply(7)
