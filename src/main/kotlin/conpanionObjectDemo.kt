fun main() {
//    dataDemo.call()
    KotlinCall.run()
    KotlinCall.call()
}

class KotlinCall{

   companion object{
       fun call(){
           println("call function calling")
       }
       fun run(){
           println("run function")
       }
   }
}



//object dataDemo{
//    var a = 10
//    fun call(){
//        println("call function calling")
//    }
//}