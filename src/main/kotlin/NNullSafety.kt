
fun main() {
    var i:Int? = null
    var name:String? = null
    print(name)

    if (name != null) {
        println(name.toLowerCase())
    }

    var name1 = name ?: "name is null" //elvish operator
    println(name1)

    var name2 = name!!.toLowerCase()
    println(name2)
}