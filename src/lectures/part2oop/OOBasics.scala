package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Jeff", 29)
  println(person.age)
  // println(person.name) <-- errors out

  val counter = new Counter

  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

// class parameters in constructors are not fields. If you add val before it in the constructor then it will be a field
class Person(name: String, val age: Int) {

  def greet(name: String): Unit = {
    println(s"${this.name} says Hi: $name") // note that this.name still exists even if it is not a val in constructor
  }

  // overloading
  def greet() = println(s"Hi, I am $name") // now $name here refers to $this.name -- it is inferred


  // overloading constructors
  def this(name: String) = this(name, 0) // calls the primary constructor
  // overloading constructors can only call another constructor, but typically is better just to use default params

}

class Writer(fname: String, surname: String, val birthYear: Int) {
  def fullName = s"$fname $surname"
}

class Novel(name: String, releaseYear: Int, author: Writer) {
  def authorAge() = releaseYear - this.author.birthYear

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newYear: Int) = new Novel(this.name, newYear, this.author)
}

class Counter(val count: Int = 0) {
  def inc: Counter = {
    // side effect
    println("incrementing")
    new Counter(count + 1)
  } // immutability by returning a new Counter so we do not modify this instance

  def dec = new Counter(count - 1) // immutability by returning a new Counter so we do not modify this instance

  def inc(n: Int): Counter = {
    if ( n<= 0 ) this
    // this calls the above inc w/ the side effect, which then calls the overloaded method, which then calls recursively
    // calls the overloaded call, etc
    else inc.inc(n -1)
  }
  def dec(n: Int) = new Counter(count - n)

  def print = println(count)
}
