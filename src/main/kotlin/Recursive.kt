fun main() {
    calling()
}
var a = 1
fun calling(){
    while(a<=5){
        println("call")
        a++
    }
    calling()
}