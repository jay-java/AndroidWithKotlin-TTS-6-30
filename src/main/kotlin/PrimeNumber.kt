fun main() {
    println("enter number to find prime or not : ")
    var a = Integer.valueOf(readLine())
    var count=0
    for(i in 1..a){
        if(a%i == 0){
            count++
        }
    }
    if(count ==2){
        println("$a is primne")
    }
    else{
        println("$a is not prime")
    }
}