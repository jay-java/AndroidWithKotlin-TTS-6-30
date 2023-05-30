package com.example.sharedpreferencesdemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var Password:EditText
    lateinit var login:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.email_id)
        Password = findViewById(R.id.password_id)
        login = findViewById(R.id.btn_id)
        val sharedPreferences = getSharedPreferences("my_pref",Context.MODE_PRIVATE)
        var getUsername = sharedPreferences.getString("email","").toString()
        var getPassword = sharedPreferences.getString("pass","").toString()
        if(getUsername != "" && getPassword != ""){
            val i = Intent(this@MainActivity,Home_activity::class.java)
            startActivity(i)
        }

        login.setOnClickListener {
            var userEmail = email.text.toString()
            var userPassword = Password.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString("email",userEmail)
            editor.putString("pass",userPassword)
            editor.apply()

            val i = Intent(this@MainActivity,Home_activity::class.java)
            startActivity(i)
        }

    }
}