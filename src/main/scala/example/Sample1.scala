package example

import org.smirkcat.loaddll._
import java.io.IOException

/**
 * @author smiklijie
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
    try {
        JarDllScala.loadLib("Sample1", "/dll/", Sample1.getClass())
        println(s"加载完成")
    } catch {
        case e: IOException =>
            println(s"加载失败,失败原因$e")
    }

    def main(args: Array[String]) {
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
        println("执行完毕")
    }

}