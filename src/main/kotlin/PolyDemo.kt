fun main() {
    var o= OVerload()
    o.call(1,"kotlin")
}
class OVerload{
    fun call() = println("call function without para")
    fun call(i:Int){
        println("call $i")
    }
    fun call(i:Int,name:String){
        println("call $i $name")
    }
}
