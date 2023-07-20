package com.example.registerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun register(view: View) {
        val i = Intent(this,Register::class.java)
        startActivity(i)
    }
    fun login(view: View){
        val i = Intent(this,Login::class.java)
        startActivity(i)
    }
}