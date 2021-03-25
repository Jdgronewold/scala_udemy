package lectures.part3fp

object HOFandCurried extends App {
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1

  println(nTimes(plusOne, 10, 1))

  def betterNTimes(f: Int => Int, n: Int): Int => Int = (x: Int) => {
      if (n <= 0) x
      else betterNTimes(f, n - 1)(f(x))
    }

  def otherNTimes(f: Int => Int, n: Int): Int => Int = {
    if ( n <= 0) (x: Int) => x
    else (x: Int) => betterNTimes(f, n-1)(f(x))
  }

  val plus10 = betterNTimes(plusOne, 10)
  println(plus10(1))

  // curried functions with multiple param lists

  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))


  // exercises

}
