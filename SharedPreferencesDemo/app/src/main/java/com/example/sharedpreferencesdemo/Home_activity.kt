package com.example.sharedpreferencesdemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Home_activity : AppCompatActivity() {
    lateinit var emTV:TextView
    lateinit var passTV:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        emTV = findViewById(R.id.email_tv_id)
        passTV = findViewById(R.id.pwd_tv_id)
        val sharedPreferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE)
        var email = sharedPreferences.getString("email","").toString()
        var pass = sharedPreferences.getString("pass","").toString()
        emTV.text = email
        passTV.text = pass
    }
}