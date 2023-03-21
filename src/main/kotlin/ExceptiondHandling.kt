import java.lang.Exception
import java.lang.NumberFormatException

fun main() {
    var d = divide()
    d.run(-12)
//    try {
//        var d = divide()
//        d.division()
//    }
//    catch (e:ArithmeticException){
//        println("denominator cannot be zero")
//    }
//    catch (e:NumberFormatException){
//        println("denominator should be integer value")
//    }
//    catch (e:Exception){
//        print("error")
//    }
//   finally {
//       println("this should be execute everytime")
//   }
}
class divide{
    fun run(id :Int){
        if(id<0){
            throw Exception("number should not less than zero")
        }
        else{
            println("id : $id")
        }
    }
    fun division(){
        println("enter i = ")
        var i = Integer.valueOf(readLine())
        println("enter j = ")
        var j = Integer.valueOf(readLine())
        var k = i / j;
        print(k)
    }
}
