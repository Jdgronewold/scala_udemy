package exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](n: B): MyList[B]
  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B] (transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]

  // concat
  def ++[B >: A](list: MyList[B]): MyList[B]

}

// ??? means scala.Nothing

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](n: B): MyList[B] = new Cons(n, Empty)

  def printElements: String = ""

  def map[B] (transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B] (transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
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

  def map[B] (transformer: MyTransformer[A, B]): MyList[B] = {
    Cons(transformer.transform(h), t.map(transformer))
  }
  def flatMap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }

  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(head)) Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }
}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

object ListTest extends App {
  val list: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty))) // linked list!
  val stringList: MyList[String] = new Cons("Hello", new Cons("Cool", new Cons("Scala", Empty))) // linked list!

  val secondList = list.add(4)
  list.add(5)
  println(list.head)

  println(secondList.toString)
  println(stringList.toString)

  println(list.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).printElements)

  println(list.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).printElements)

  println(list.flatMap(new MyTransformer[Int, MyList[String]] {
    override def transform(elem: Int): MyList[String] = Cons(s"${elem} cookies", Empty)
  }).printElements)

  println(list.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = Cons(elem, Cons(elem + 1, Empty))
  }).printElements)
}
