def squareList(xs: List[Int]): List[Int] = xs match {
  case Nil => xs
  case y :: ys => y * y :: squareList(ys)
}

def squareList1(xs: List[Int]): List[Int] =
  xs map (x => x * x)

squareList(List(2, 3, 6))
squareList1(List(2, 3, 6))

var nums = List(2, 6, -5, 32, -87, -4, 18)

// List filter
nums filter (x => x > 0)
nums filterNot (x => x > 0)

// Pair of Lists with filter and filterNot results
nums partition (x => x > 0)

// Longest prefix with predicated true
nums takeWhile (x => x > 0)
nums dropWhile (x => x > 0)

// Pair of Lists with takeWhile and dropWhile results
nums span (x => x > 0)

val data = List("a", "a", "a", "b", "c", "c", "a")

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (first, rest) = xs span (y => y == x)
    first :: pack(rest)
}

pack(data)

def encode[T](xs: List[T]): List[(T, Int)] =
  pack(xs) map (ys => (ys.head, ys.length))

encode(data)

def sum(xs: List[Int]): Int = xs match {
  case Nil => 0
  case y :: ys => y + sum(ys)
}

def sum2(xs: List[Int]): Int = {
  //(0 :: xs) reduceLeft ((x, y) => x+y)
  (0 :: xs) reduceLeft (_ + _)
}

def sumWithFoldLeft(xs: List[Int]): Int = {
  (xs foldLeft 0)(_ + _)
}

sumWithFoldLeft(nums)
sum2(nums)
sum(nums )

def concat[T](xs: List[T], ys: List[T]): List[T] = {
  (xs foldRight ys)(_ :: _)
}

concat(List("gabriel", "marcelo"), List("volpe", "ybañez"))
