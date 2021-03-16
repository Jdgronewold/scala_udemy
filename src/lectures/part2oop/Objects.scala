package lectures.part2oop

object Objects extends App {
  // Scala does not have class level functionality - no static methods
  // it has objects instead

  object Person { // objects do not receive parameters
    val N_EYES = 2 // this is the class level functionality in Scala
    def canFly: Boolean = false

    // factory methods defined here
    def apply(mother: Person, father: Person): Person = new Person("blah")
  }

  class Person(val name: String) {
    // instance level functionality from "static" functionality defined in the object
    // this is called Companions between the class Person and object Person


  }

  println(Person.N_EYES)
  println(Person.canFly)

  // use an object as a singleton -> type + only instance

  val mary = Person
  val john = Person
  println(mary == john) // true

  val bill = new Person("bill")
  val wendy = new Person("wendy")
  println(bill == wendy) // false

  val blah = Person(bill, wendy) // calls the apply method in the object

  // Scala Applications = scala object with
  // def main(args: Array[String]): Unit = {} <-- all the code you write in the object goes into this function

}
