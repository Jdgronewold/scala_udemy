package lectures.part2oop

object Exceptions extends App {
  val x: String = null
  // println(x.length) <-- throws NPE

//  val aWeirdValue: String = throw new NullPointerException // Nothing type

  // throwable classes extend the Throwable class
  // Exceptions and Error are major subtypes

  // Exceptions throw something wrong with program,
  // Error is something wrong with system/jvm like a stack overflow

  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No Int for you")
    else 42
  }

  val potentialFail: AnyVal = try {
    // AnyVal is kinda the kitchen sink <- in this case it is either an Int or Unit
    getInt(true)
  } catch {
//    case e: NullPointerException => println("Caught Runtime Exception") <-- this will not get caught and will crash program
    case e: RuntimeException => println("Caught Runtime Exception")
  } finally {
    // will get executed no matter what
    // this block is optional and does not influence the return type of expression
    // only used for side effects
    println("Finally")


    class MyException extends Exception

    // lol crashing things
    // OOM
    // val array = Array.ofDim(Int.MaxValue)

    // SO
    // def infinite: Int = 1 + infinite
    // val noLimit = infinite


  }

}
