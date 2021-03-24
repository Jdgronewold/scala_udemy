package lectures.part2oop

object AnonymousClass extends App {
  abstract class Animal {
    def eat: Unit
  }

  // anonymous class - compiler builds a class from the code block and assigns an anon name for it
  val funnyAnimal = new Animal { // this is odd because usually you cannot instantiate an abstract class!
    override def eat: Unit = println("womp womp")
  }

  println(funnyAnimal.getClass)
}
