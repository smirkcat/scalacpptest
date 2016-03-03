package example

class Sample1 {
  // --- Native methods
  @native def intMethod(n: Int): Int
  @native def booleanMethod(b: Boolean): Boolean
  @native def stringMethod(s: String): String
  @native def intArrayMethod(a: Array[Int]): Int
}
// --- Code in App body will get wrapped in a main method on compilation
object Sample1 extends App {
  // --- Main method to test our native library
  System.loadLibrary("Sample1")
  val sample = new Sample1
  val square = sample.intMethod(5)
  val bool = sample.booleanMethod(true)
  val text = sample.stringMethod("java")
  val sum = sample.intArrayMethod(Array(1, 1, 2, 3, 5, 8, 13))
  println(s"scalaintMethod: $square")
  println(s"scalabooleanMethod: $bool")
  println(s"scalastringMethod: $text")
  println(s"scalaintArrayMethod: $sum")
}