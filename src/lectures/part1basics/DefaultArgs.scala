package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  // you can provide a default value in

  @tailrec
  def factorialHelper(x: Int, accum: Int = 1): BigInt = {
    if (x <= 1) accum
    else factorialHelper(x - 1, accum * x)
  }

  println(factorialHelper(10))

  // it is possible to name the arguments for ex:

  def savePicture(format: String = "jpg", height: Int = 1920, width: Int = 1080): Unit = println("Blah")

  savePicture(width = 800, height = 200) // don't need to give the others or provide them in order any more
}
