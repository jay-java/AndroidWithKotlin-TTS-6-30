package com.example.sqlitebd

class Model {
    var id:Int = 0
    var name:String =""
    var details:String = ""
    override fun toString(): String {
        return "Model(id=$id, name='$name', details='$details')"
    }
}