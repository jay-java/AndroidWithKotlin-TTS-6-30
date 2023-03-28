fun main() {
    var o = OuterClass()
    o.run()
//    var o1 = OuterClass.InnerClass()
//    o1.callInner()
    var o1 = OuterClass().InnerClass()
    o1.callInner()
}
class OuterClass{
    var i = 1
    fun run(){
        println("i = $i")
    }
    inner class InnerClass{
        fun callInner(){
            print("inner class function $i")
        }
    }
}