fun main() {
    var c = Child1()
    c.call()
}
open class Parent1{
    open fun call(){
        println("call in parent")
    }
}
class Child1:Parent1(){
    override fun call(){
        println("call in child")
        super.call()
    }
}