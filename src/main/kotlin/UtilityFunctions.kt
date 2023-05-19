fun main() {
    var s1 =Stu()
    println(s1.id)
    println(s1.name)

    var s =  s1.let {
        it.id = 14
        it.contact=1242
        it.name="java"
        123
    }
    println(s1)


//    s1.apply {this
//        id = 13
//        name="kotlin"
//        contact = 1244
//    }
//    println(s1)
}

data class Stu(var id:Int = 1,var name:String = "",var contact:Int =1)