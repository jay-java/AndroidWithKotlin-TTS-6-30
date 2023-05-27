package com.example.sqlitebd

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.view.Display.Mode

class DBHelper(context:Context):SQLiteOpenHelper(context, db_name,null, db_version) {

    companion object {
        private val db_name = "task"
        private val db_version = 1
        private val tb_name = "users"
        private val ID = "id"
        private val task_name = "uname"
        private val task_details = "udetails"
        private val u_gender = "gender"
        private val u_hobby = "hobby"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var createTable = "CREATE TABLE $tb_name($ID INTEGER PRIMARY KEY AUTOINCREMENT, $task_name TEXT, $task_details TEXT,$u_gender TEXT, $u_hobby TEXT);"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var drop_table = "DROP TABLE IF EXISTS $tb_name;"
        db?.execSQL(drop_table)
        onCreate(db)
    }

    fun addUser(model:Model):Boolean{
        var db = this.writableDatabase
        val values = ContentValues()
        values.put(task_name,model.name)
        values.put(task_details,model.details)
        values.put(u_gender,model.gender)
//        values[]
//        values.put(u_hobby,model.hobby)
        var s = db.insert(tb_name,null,values)
        db.close()
        return ((s.toInt())!=-1)
    }
    fun getUserById(uid:Int):Model{
        val model = Model()
        val db = writableDatabase
        val select  = "SELECT * FROM $tb_name WHERE $ID = $uid"
        val cursor = db.rawQuery(select,null)
        cursor?.moveToFirst()
        model.id = Integer.parseInt(cursor.getString(cursor.getInt(0)))
//        model.name = cursor.getString(cursor.getColumnIndex(task_name)))
//        model.details = cursor.getString(cursor.getColumnIndex(task_details))
        cursor.close()
        return  model
    }
}