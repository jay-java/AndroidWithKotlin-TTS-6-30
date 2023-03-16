fun main() {
    var c = Callinterface()
    c.interface1()
    c.interface2()
    c.interface3()
    c.interface4()
}
interface inter1{
    fun interface1()
    fun interface3(){
        println("intertface 3 in interface 1")
    }
}

interface inter2{
    fun interface2()
    fun interface4(){
        println("intertface 4 in interface 2")
    }
}
class Callinterface:inter1,inter2{
    override fun interface1() {
        println("inter 1")
    }

    override fun interface2() {
        println("inter 2")
    }

}
