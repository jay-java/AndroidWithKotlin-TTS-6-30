package com.example.firebaseproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShowDataActivity : AppCompatActivity() {

    lateinit var showName:TextView
   // lateinit var showEmail:TextView
   // lateinit var showContact:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)

        showName = findViewById(R.id.showName)
       // showEmail = findViewById(R.id.showEmail)
       // showContact = findViewById(R.id.showContact)

        var name = intent.getStringExtra("name")
        showName.text = name

    }
}