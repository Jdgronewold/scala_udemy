package lectures.part1basics

object SmartStrings extends App {
  val str = "Hello I am learning Scala"

  println(str.charAt(2))

  // more or less lots of normal string ops
  // startsWith
  // substring
  // replace
  // toLowerCase
  // etc
  // split
  // reverse
  // .take


  val aNumStr = "45"
  val aNum = aNumStr.toInt

  // +: and :+ can be used to prepend and append strings

  // string interpolaters
  val age = 12
  val name = "Jeff"
  val greeting = s"Hello my name is $name and I am $age year old and next year I will be ${age + 1}"

  // F interpolater
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"

  // %s means string, %2.2f means at least two characters to a precision of 0.01

  // raw interpolator

  println(raw" this is a \n newline") // will not print a new lie





}
