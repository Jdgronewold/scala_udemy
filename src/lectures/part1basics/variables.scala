package lectures.part1basics

object variables extends App {
  // Vals are immutable
  // types are typically inferred by the compiler
  val x: Int = 2
  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val aShort: Short = 2345
  val aLong: Long = 1234224555533532322L
  val aFloat: Float = 2.6F
  val aDouble: Double = 3.98

  // Vars can be re assigned
  var aVariable: Int = 4
  aVariable = 9

}
