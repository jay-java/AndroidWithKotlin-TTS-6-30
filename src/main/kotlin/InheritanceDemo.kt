fun main() {
    var c = Child("kotlin")
    c.childFunction()
    c.parentFunction()
}
open class Parent(var name: String){
    init {
        println("parent init block")
    }
    fun parentFunction(){
        println("parent class $name")
    }
}
class Child(var name1:String): Parent(name = name1){
    init {
        println("child init block")
    }
    fun childFunction(){
        println("child class $name1")
    }
}
