package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      val result = n * factorial(n - 1)
      result
    }
  }

  // factorial(5000) will blow up the call stack, so we have to be a bit smarter in how we implement large loops

  def anotherFac(n: Int): BigInt = {
    @tailrec // will tell compiler it is supposed to be tail recursive and compiler will be unhappy if it is not
    def factorialHelper(x: Int, accum: Int): BigInt = {
      if (x <= 1) accum
      else factorialHelper(x - 1, accum * x)
    }

    factorialHelper(n, 1)
  }
  /*
    this one works with big numbers because the else statement returns the entire function -- the last expression has no
    intermediate result that scala needs to save for later. This is called Tail Recursion

    the main trick is just to pass in an acummulator that used to be an intermediate stage but now is passed into the
    recursive function
   */
  @tailrec
  def concatTailRec(aString: String, n: Int, accum: String): String = {
    if ( n <= 0 ) accum
    else concatTailRec(aString, n - 1, aString + accum )
  }

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntil(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeUntil(n / 2, true)
  }

  // however many recursive calls you have in a code path is the # of accumulators you need to have

  def fib(n: Int): Int = {
    def fibTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if ( i >= n ) last
      else fibTailRec(i + 1, last + nextToLast, last)
    }

    if (n <= 2 ) 1
    else fibTailRec(2, 1, 1)
  }

}
