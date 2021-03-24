package lectures.part2oop

object CaseClasses extends App {
  case class Person(name: String, age: Int) {}

  // case classes are very useful in instances where we want some default behavior from classes

  // class parameters are promoted to fields
  val jim = new Person("jim", 30)
  println(jim.name)

  // sensible toString method
  println(jim.toString)

  // equals and hashCode implemented out of the box
  val jim2 = new Person("jim", 30)
  println(jim2 == (jim)) // true, which wouldn't be the case if it were not a case class

  // handy copy method
  val jim3 = jim.copy(age = 31)

  // companion objects
  val thePerson = Person

  // apply method is the same as the constructor
  val mary = Person("mary", 29)

  // case classes are serializable (send through the network/jvm's)

  // case classes have extractor patterns
  // can be used in pattern matching

  case object UnitedKingdom {
    def name: String = "blah blah"
  }

}
