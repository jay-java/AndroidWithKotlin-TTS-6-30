fun main() {
    var s = "hello kotlin"
    println(s)
    var s1 = "hello kotlin"
    println(s1)
    var c = charArrayOf('h','e','l','l','o')
    println(c)
    println(s.length)
    println(s.plus(s1))
    println(s)
    println(s.get(2))
    println(s.compareTo(s1))
    println(s.equals(s1))
    if(s == s1){
        println("yes")
    }
    else{
        println("no")
    }
}