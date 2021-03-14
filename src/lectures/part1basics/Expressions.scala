package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // EXPRESSION

  // For equality == and !=

  var aVariable = 3
  aVariable += 2 // -= *= /=

  // Instructions (Do) vs Expression (Value)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // <-- in scala we almost always think in expressions

  var i = 0

  // DON'T DO THIS - Specific to imperative programming, not functional programming
  while(i < 10) {
    println(i)
    i += 1
  }

  // Everything in Scala is an expression

  val aWeirdValue = (aVariable = 5) // Unit type == void type

  // side effects are Unit type -> printing to the console, reassignment, while loops, etc

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

  // value of the block is the value of the last expression
}
