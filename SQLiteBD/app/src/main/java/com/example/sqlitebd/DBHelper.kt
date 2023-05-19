package com.example.sqlitebd

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context:Context):SQLiteOpenHelper(context, db_name,null, db_version) {

    companion object {
        private val db_name = "task"
        private val db_version = 1
        private val tb_name = "tasklist"
        private val ID = "id"
        private val task_name = "taskName"
        private val task_details = "taskDetails"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}