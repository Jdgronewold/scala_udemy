package lectures.part3fp

object MapFlatmapFilterFor extends App {
  val list = List(1,2, 3)

  println(list)
  println(list.map(_ + 1))

  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List("a", "b", "c", "d")

  // iterations
  val combinations = numbers.flatMap(x => chars.map(c => s"${c}${x}"))
  println(combinations)

  // for combinations
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
  } yield s"${c}${n}"

  println(forCombinations)

  // syntax
  list.map { x =>
    x * 2
  }
}
