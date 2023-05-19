package com.example.sqlitebd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var addBtn:Button
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBtn = findViewById(R.id.add_btn)
        recyclerView = findViewById(R.id.recyclerView_id)
        addBtn.setOnClickListener {
            var intent = Intent(this@MainActivity,AddUser::class.java)
            startActivity(intent)
        }
    }
}