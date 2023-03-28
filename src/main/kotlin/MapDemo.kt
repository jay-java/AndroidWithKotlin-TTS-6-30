fun main() {
    var set = mutableSetOf(1,1,"kotlin","kotlin",0,false,true,454.4)
    println(set)
    set.add(23)
    println(set)


    var map = mapOf<Int,String>(1 to "c",2 to "c++",3 to "java",4 to "kotlin")
    println(map)
    println(map.get(4))
    for(i in map){
        println(i)
    }

    var map1 = mapOf(1 to "c","lang" to "c++",3 to "java",4 to "kotlin")
    println(map1)

    var map2 = mutableMapOf<Int,String>()
    map2.put(1,"c")
    map2.put(2,"c++")
    println(map2)
    map2.put(3,"kotlin")
    println(map2)
}
