package lectures.part3fp

object WhatsAFunction extends App {
  // use functions as first class elements
  // coming from OOP world, it is harder to use functions as first class elements
  // instead using anonymous classes in the place of a function and instantiate it/calling execute


  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2)) // calling it like a function - scala uses apply to make things more functioney

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 4)

  // scala supports up to Function22 with 22 params

  def adder = new Function2[Int, Int, Int] { // A, B, Result types
    override def apply(a: Int, b: Int): Int = a + b
  }

  println(adder(4, 6))

  // all scala functions are objects

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  // curried function
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Int => Int = new Function1[Int, Int] {
        override def apply(y: Int) = x + y
      }
  }

  val adder3 = superAdder(3)
  val total = adder3(4)

  println(total)
  println(superAdder(3)(4))
}

// OOP world
class Action {
  def execute(element: Int): String = ???
}

// FP
trait MyFunction[A, B] {
  def apply(element: A): B
}
