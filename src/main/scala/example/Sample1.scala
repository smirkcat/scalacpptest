package example

/**
 * @author 李杰
 * 2016年4月14日16:32:20
 * 
 */

class Sample1 {
  // --- Native methods
  @native def intMethod(n: Int): Int
  @native def booleanMethod(b: Boolean): Boolean
  @native def stringMethod(s: String): String
  @native def intArrayMethod(a: Array[Int]): Int
}
//伴生对象 ，staic
object Sample1 {
  //此处相当于static方法块
  System.loadLibrary("Sample1")
  def main(args: Array[String]){
    // --- Main method to test our native library
  val sample = new Sample1
  val square = sample.intMethod(5)
  val bool = sample.booleanMethod(true)
  val text = sample.stringMethod("java")
  val sum = sample.intArrayMethod(Array(1, 1, 2, 3, 5, 8, 13))
  println(s"scalaintMethod: $square")
  println(s"scalabooleanMethod: $bool")
  println(s"scalastringMethod: $text")
  println(s"scalaintArrayMethod: $sum")
  println(s"执行完毕")
  }
  
}