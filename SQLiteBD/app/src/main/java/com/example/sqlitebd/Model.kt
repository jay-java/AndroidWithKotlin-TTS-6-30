package com.example.sqlitebd

class Model {
    var id:Int = 0
    var name:String =""
    var details:String = ""
    var gender: String =""
    var hobby = arrayOf<String>()
    override fun toString(): String {
        return "Model(id=$id, name='$name', details='$details', gender='$gender', hobby=$hobby)"
    }

}