package lectures.part2oop

object Inheritance extends App {
  sealed class Animal { // cannot extend Animal in other files, just this one because of sealed
    val creatureType = "wild"
    protected def eat = println("nom") // subclasses allowed to call inside, but not outside the class

    private def poop = println("womp")

    protected final def drink = println("slurp") // can not override
  }

  class Cat extends Animal {
    def crunch = {
      eat // allowed
      println("crunch crunch")
    }
  }

  val tidbit = new Cat
  // tidbit.eat <- errors because protected
  // tidbit.poop <- errors

  // scala has single class inheritance (only one at a time) and only passes on non private defs

  // if you extend a class, the jvm will call the constructor from the parent class first and then it will call the
  // constructor from the sub class

  class Person(name: String)
  class Adult(name: String, age: Int) extends Person(name) // how to extend with constructors that take multiple params

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    override def eat: Unit = {
      super.eat
      println("nom nom nom")
    }
  }

  val bean = new Dog("domestic")
  bean.eat

  // type substitution
  val unknownAnimal: Animal = new Dog("K9") // polymorphism
  println(unknownAnimal) // <-- goes to the most overridden def possible and calls Dog.eat

  // preventing overrides
  // keyword final will prevent derived classes from overriding or from being extended if it is put on the entire class
  // or you can seal the class - it lets you extend in the current file but prevents extension in other files

}
