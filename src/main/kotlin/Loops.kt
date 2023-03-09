fun main() {
    for(i in 1..5){
        for(j in 1..i){
            print("* ")
        }
        println()
    }




    myLoop@ for(i in 1..5){
        for(j in 1..5){
            println("$i $j")
            if(i == 3 && j ==3)
                break@myLoop
        }
    }



//    for(i in 1..5 step 2){ // step 2 means add 2 in i
//        println(i)
//    }
//    for(i in 1 until 5){ //increasing
//        println(i)
//    }
//    for(i in 5 downTo 1 step  2){ //downTO
//        println(i)
//    }
//    val n = 2
//    for(i in 1..10){
//        println(n.toString()+" x "+i+" = "+(n*i))
//        println("$n x $i = ${n*i}") //string templating
//    }


//    var i  = 5
//    do {
//        println("hello")
//        i--
//    }
//    while (i>=1)

//    var num = 2
//    var i =1
//    while(i<=10){
//        println(num*i)
//        i++
//    }

//    var count = 5

//    while (count >=1){
//        println("hello kotlin")
//        count--
//    }
}