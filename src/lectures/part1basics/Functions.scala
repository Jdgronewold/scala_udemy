package lectures.part1basics

object Functions extends App {

//  def aFunction(a: String, b: Int): String =
//    a + " " + b
// dont need to put it in a code block

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def noParameters(): Int = 42
  println(noParameters) // don't need to actually invoke it with () to call it

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  // with a recursive function we HAVE to type it - the compiler cannot figure out the return type on its own

  println("hello", 3)
  // in Scala we use recursive functions to function as loops!
  // woah


  // you can use Unit as a return type if we have side effects

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  def factorial(n: Int): Int = {
    if (n<=0) 1
    else n * factorial(n-1)
  }

  def fib(n: Int): Int = {
    if (n <= 2) 1
    else fib(n - 1) + fib(n - 2)
  }

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }


}
