fun main() {
//    <generics>
    var list = mutableListOf(1,1,"kotlin",34.3,true)
    println(list)
    list.add("java")
    println(list)
    list.add(34)
    println(list)
    list.remove(true)
    println(list)


    var list2 = mutableListOf(1,2,3,"kotlin",false)
    list2.addAll(list)
    println(list2)

//    val a = arrayOf(1,2,3)
//    for(i in a){
//        print("$i ")
//    }
////    print(a[5])
//    a[2] = 23
//    for(i in a){
//        print("$i ")
//    }

    var u1 = user()
    u1.id =  10
    u1.name = "kotlin"
    println(u1)
    var u2 = user()
    u2.id =  11
    u2.name = "java"
    println(u2)

    var userList = mutableListOf<user>()
    userList.add(u1)
    userList.add(u2)
    println(userList)

}
class user(){
    var id:Int? = null
    var name:String? = null
    override fun toString(): String {
        return "user(id=$id, name=$name)"
    }

}