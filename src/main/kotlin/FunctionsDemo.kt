fun call(){
    println("call function called")
}
fun call1(i:Int){
    println("i = $i")
}
fun call2():Int{
    println("enter data : ")
    var i  = Integer.valueOf(readLine())
    return i;
}
fun getSquare(j:Int):Int{
    var a:Int = 0
    for(i in 1..10){
        a = i*j
        println("$i x $j = $a")
    }
    return a
}
fun main() {
    call()
    call1(12)
    var r:Int = call2()
    println("r = $r")
    println("enter number to get table of number : ")
    var i  = Integer.valueOf(readLine())
    var q= getSquare(i)
    println(q)
}