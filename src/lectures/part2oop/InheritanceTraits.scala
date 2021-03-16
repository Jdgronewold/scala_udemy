package lectures.part2oop

object InheritanceTraits extends App {
  // abstract - leaving fields unimplemented

  abstract class Animal {
    val creatureType: String // not implemented - sublasses will implement them
    val eat: Unit
  }

  // val unicorn = new Animal <-- this does not work - you cannot instatiate it

  class Dog extends Animal {
    override val creatureType: String = "canine"
    override val eat: Unit = println("crunch crunch")
  }

  // traits -> can be inherited along classes
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"
    override val eat: Unit = "grawr grawr"

    override def eat(animal: Animal): Unit = println(s"I am a croc and eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  println(croc.eat(dog))

  // traits vs abstract classes
  // both can have abstract and non abstract vals defined in them
  // 1 - traits cannot have constructor parameters
  // 2 - you can inherit multiple traits vs one class inherited
  // 3 - typically chooose a trait if it describes a behavior, abstract classes are typically a type of thing

  // type hierarchy
  // scala.Any <-- scala.AnyRef (all classes extend AnyRef by default)
  // scala.Null <-- can replace anything
  // scala.AnyVal <-- Int, Unit, Boolean, etc inherit from this
  // scala.Nothing
}
