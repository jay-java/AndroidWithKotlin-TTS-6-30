import java.util.Objects
var b = 10
fun aa(){
var  b =23
    println("b = $b")
}
fun main() {
    var s = SBI()
    s.interest()
    s.loan()
    var p = PNB()
    p.interest()
    p.loan()
    var k = KOTLIN()
    k.interest()
    k.loan()

}
//fun callRBI(objects: Array<RBI>){
//    for(obj in objects){
//        obj.loan()
//        obj.interest()
//    }
//}

abstract class RBI{
    abstract fun interest()
    abstract fun loan()

    fun repoRate(){
        println("+-4%")
        var a=10
    }
}
class SBI:RBI(){
    override fun interest() {
        println("SBI : 7%")
        println("a = $a")
    }

    override fun loan() {
        println("SBI loan : 8%")
    }
}
class PNB:RBI(){
    override fun interest() {
        println("PNB interest : 8%")
    }

    override fun loan() {
        println("PNB loan : 9%")
    }

}
class KOTLIN:RBI(){
    override fun interest() {
        println("KOtlin interest : 10%")
    }

    override fun loan() {
        println("kotlin loan : 6")
    }

}