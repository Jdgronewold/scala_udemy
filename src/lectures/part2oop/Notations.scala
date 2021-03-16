package lectures.part2oop

object Notations extends App {
  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person) = s"${this.name} is hanging out with ${person.name}" // Scala does not treat method names as reserved
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)

    def unary_! : String = s"$name, what the heck?!"

    def isAlive: Boolean = true

    def apply(): String = {
      s"Hi, my name is $name and I like $favoriteMovie"
    }
  }

  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception"))
  // syntactic sugar
  println(mary likes "Inception") // equally valid -> infix notation or operator notation (needs single parameter)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom) // woah

  // all operators are methods like the +, *, -, etc try doing 1. and seeing what methods are allowed on the number

  // prefix notation

  val x = -1
  val y = 1.unary_- // unary operators are prefixes, and only work with -, +, !, and ~

  println(!mary) // <-- will call unary_!

  // post fix notations
  println(mary.isAlive)
  // println(mary isAlive) womp <- inteliJ did not like but is valid

  // apply function is special
  println(mary.apply())
  println(mary())

  println((mary + "the Rockstar")()) // "calls the apply function with the return of the + method we overloaded
}
