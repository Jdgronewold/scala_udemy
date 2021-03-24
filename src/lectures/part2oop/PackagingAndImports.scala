package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming} // curly braces needed to alias
// import playground._ use the underscore if the  list above is too long

object PackagingAndImports extends App {
  // can grab that because it is in the same package
  val writer = new Writer("jeff", "gronewold", 1991)

  val cindy = new Princess("cindy") // Cinderella is aliased

  val cindy2 = new playground.Cinderella("cindy") // if import line is not above

  // packages are ordered in hierarchy that matches folder in file system

  // package object lives in package.scala
  runAnywhere

  val prince = new PrinceCharming

  // default imports - automatically imported
  // ex: java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
