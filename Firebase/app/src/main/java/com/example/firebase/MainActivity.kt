package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var addUser:Button
    private lateinit var fetchUser:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addUser = findViewById(R.id.add_user)
        fetchUser = findViewById(R.id.fetch_user)

        addUser.setOnClickListener {
            val intent = Intent(this@MainActivity,AddUser::class.java)
            startActivity(intent)
        }
        fetchUser.setOnClickListener {
            val intent = Intent(this@MainActivity,UsersList::class.java)
            startActivity(intent)
        }
    }
}