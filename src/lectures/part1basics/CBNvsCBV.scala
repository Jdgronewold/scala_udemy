package lectures.part1basics

object CBNvsCBV extends App {
  // in this the exact value of x is computed before the function run and then uses that value when it runs the
  // function
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // => means that the function will not evaluate x into the function - the expression is passed in as is and then
  // is evaluated when it is actually invoked during run time/ the => delays the evaluation of the parameter
  // useful in lazy streams and things that might fail if the parameter is evaluated too early
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  // calling something by name with =>
}
