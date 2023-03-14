fun main() {
    var obj = A(1,2,"kotlin")
    obj.call()
    var obj1 = A(1,"kotlin")
    println(obj.add(1,2))

    var b = B(1,"kotlin")
    b.printing()
}
class B(var i:Int,var name:String,var age:Int,var per:Double){

//    var i:Int = 12
//    lateinit var name:String
    init{
        print("hello kotlin in b class")
    }
    constructor(i:Int,name:String):this(i,name,0,0.0)
    constructor(i:Int,name:String,per:Double):this(i=1,name="kotlin",34,56.5)
    constructor(i:Int):this(i=1,name="kotlin",34,56.5)
    fun printing(){
        println("$i $name $age $per")
    }
}
class A(var a:Int,var b:Int,var name:String){

    fun call(){
        println("$a $b $name")
    }
    constructor(i:Int,data:String):
                this(a =12,b = 23,name = "kotlin")
    constructor(i:Int):
            this(a =12,b = 23,name = "kotlin")
    init {
        println("first init")
    }
    init {
        print("second inti")
    }
    fun add(a:Int,b:Int):Int{
       return  a+b
    }
}