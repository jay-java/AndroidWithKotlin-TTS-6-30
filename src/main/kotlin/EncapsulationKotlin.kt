fun main() {
    var s1 = Stud(1, "kotlin", 45.4)
    var s2 = Stud(1, "kotlin", 45.4)
    println(s1)
    println(s2)
    println(s1 == s2)
}
data class Stud(var id: Int, var name: String, var per: Double) {

}