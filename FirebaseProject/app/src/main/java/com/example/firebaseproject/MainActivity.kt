package com.example.firebaseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var addUser:Button
    private lateinit var showUser:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addUser = findViewById(R.id.add_user_BTN)
        showUser = findViewById(R.id.show_user_BTN)

        addUser.setOnClickListener {
            val intent = Intent(this@MainActivity,add_user::class.java)
            startActivity(intent)
        }
    }
}