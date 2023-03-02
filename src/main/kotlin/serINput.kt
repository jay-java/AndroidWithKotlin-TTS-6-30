import com.sun.jdi.connect.Connector.IntegerArgument
import java.util.Scanner
fun main() {
    println("enter name : ")
    var name = readLine()
    println("name is $name")

    println("enter num : ")
    var i:Int = Integer.valueOf(readLine())
    println("num is : $i")

    var sc = Scanner(System.`in`)
    println("enter age : ")
    var age = sc.nextInt()
    println("age is $age")

    println("enter new string : ")
    var name2 = sc.next()
    println("new string is : $name2")
}