package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // A is the generic type
    //def add(element: A): MyList[A] = ???
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Dog
      if we add an animal to a list of cats, it will turn it into a list of animals, which is the above
      technical definition
     */
  }

  // traits can also have generics, but objects cannot

  val intLists = new MyList[Int]
  val stringLists = new MyList[String]

  class MyMap[Key, Value] // multiple type parameters

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyIntList = MyList.empty[Int]

  // variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // if cat extends Animal, does a list of Cats extend list of Animals? Yes = COVARIANCE
  class CovariantList[+A] // <-- + denotes covariance
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // is animalList.add(new Dog) valid?

  // Invarianct List
  class InvariantList[A]
  val invariantList: InvariantList[Cat] = new InvariantList[Cat]
  // no dogs allowed

  // Contra variance <-- exact opposite of covariant list
  class Trainer[-A]
  val contrvariantList: Trainer[Cat] = new Trainer[Animal] // <-- can use a trainer of animal to train a cat


  // bounded types
  class Cage[A <: Animal](animal: A) // only allow subtypes of Animal - lower bounded
  // >: for upper bounded means only allows super types of Animal
  val cage = new Cage(new Dog)


}
