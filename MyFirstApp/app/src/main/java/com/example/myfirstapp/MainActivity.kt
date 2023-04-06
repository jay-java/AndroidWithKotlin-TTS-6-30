package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var login:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.login_id)
        login.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Login::class.java))
            Toast.makeText(this,"Login Acticity",Toast.LENGTH_LONG).show()
        })
    }
}