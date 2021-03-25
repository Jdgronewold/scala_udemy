package lectures.part3fp

object AnonymousFunctions extends App {

//  val doubler = new Function[Int, Int] {
//    override def apply(v1: Int): Int = v1 * 2
//  }

  val doubler: Int => Int = (x) => x * 2 // lambda

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  val justDoSomething = () => 3

  println(justDoSomething) // lambdas be invoked
  println(justDoSomething()) // value returned by function

  val stringToInt = { (string: String) =>
    string.toInt
  }

  // more sugar

  val increment: Int => Int = _ + 1 // equivalent to x => x + 1

  val niceAdder: (Int, Int) => Int = _ + _ // equiv to (a, b) => a + b

  val curriedAdder: Int => Int => Int = (x) => (y) => x + y
}
