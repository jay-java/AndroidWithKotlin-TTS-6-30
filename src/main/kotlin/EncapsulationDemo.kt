fun main() {
    var s1 = Student()
    s1.setId(12)
    s1.setName("kotlin")
//    println(s1.getId())
//    println(s1.getName())
    println(s1)
}

class Student {
    private var id: Int = 0
    fun setId(id: Int) {
        this.id = id
    }
    fun getId(): Int {
        return id
    }
    private var name: String = ""
    fun setName(name:String){
        this.name = name
    }
    fun getName():String{
        return name
    }
    override fun toString(): String {
        return super.toString()
    }

}