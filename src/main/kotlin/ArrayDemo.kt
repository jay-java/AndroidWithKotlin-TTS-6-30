fun main() {
    var a = arrayOf(1,2,3,3,5)
    println("enter value of i : ")
    var i = Integer.valueOf(readLine())
    var count = 0
    for(j in 0..4){
        if(a[j] == i){
            count++
        }
    }
    if(count>0){
        print("yes $count times")
    }
    else{
        print("no")
    }




//    var a  = arrayOf<generics> ->we can assign datatype to array
//    var a  = arrayOf(1,2,"jay",'g',56.65,false)
//    for(krunal in a){
//        print("$krunal ")
//    }
//    a.set(3,2)
//    a[5] = true
//    println()
//    for(krunal in a){
//        print("$krunal ")
//    }
//    println()
//    println(a.get(4))


//    var a = arrayOf(1,2,3,4,5)
//    for(i in 0..4){
//        println("value at $i is ${a[i]}")
//    }
//    for(ele in a){
//        println(ele)
//    }
}