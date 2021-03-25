package exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](n: B): MyList[B]
  def printElements: String

  override def toString: String = "[" + printElements + "]"

  // higher-order functions -> where functions are first class citizens and receive/or return functions
  def map[B] (transformer: A => B): MyList[B]
  def flatMap[B] (transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  // concat
  def ++[B >: A](list: MyList[B]): MyList[B]

  def forEach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B // more or less a reduce function
}

// ??? means scala.Nothing

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](n: B): MyList[B] = new Cons(n, Empty)

  def printElements: String = ""

  def map[B] (transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B] (transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  def forEach(f: Nothing => Unit): Unit = () // () is Unit value
  def sort(compare: (Nothing, Nothing) => Int) = Empty
  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty

  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}


case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](n: B): MyList[B] = Cons(n, this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t ++ list)

  def map[B] (transformer: A => B): MyList[B] = {
    Cons(transformer(h), t.map(transformer))
  }
  def flatMap[B] (transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(head)) Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def forEach(f: A => Unit): Unit = {
    f(h)
    t.forEach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {

    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) Cons(x, sortedList)
      else Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = tail.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Cons(zip(head, list.head), t.zipWith(list.tail, zip))

  def fold[B](start: B)(operator: (B, A) => B): B = {
    val newStart = operator(start, head)
    t.fold(newStart)(operator)
  }

}
// We made these during the OOP section, but no longer needed because we are using the functions scala supports
//trait MyPredicate[-T] { // T => Boolean
//  def test(elem: T): Boolean
//}
//
//trait MyTransformer[-A, B] { // A => B
//  def transform(elem: A): B
//}

object ListTest extends App {
  val list: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty))) // linked list!
  val stringList: MyList[String] = new Cons("Hello", new Cons("Cool", new Cons("Scala", Empty))) // linked list!

  val secondList = list.add(4)
  list.add(5)
  println(list.head)

  println(secondList.toString)
  println(stringList.toString)

  println(list.map((elem: Int) => elem * 2).printElements)

//  this is the same as the following line
//  println(list.filter(new Function1[Int, Boolean] {
//    override def apply(elem: Int): Boolean = elem % 2 == 0
//  }).printElements)

  println(list.filter((elem: Int) => elem % 2 == 0).printElements)

  // leaving this as a non-anonymous function for educational purposes
  println(list.flatMap(new Function1[Int, MyList[String]] {
    override def apply(elem: Int): MyList[String] = Cons(s"${elem} cookies", Empty)
  }).printElements)

  println(list.flatMap((elem: Int) => Cons(elem, Cons(elem + 1, Empty))).printElements)

  println(list.sort((x: Int, y: Int) => y - x).printElements)

  println(list.zipWith[String, String](stringList, _ + "-" + _ )) // shortened lambda functions

  println(list.fold(0)(_ + _))
}
