package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Home : AppCompatActivity() {
    lateinit var nameText:TextView
    lateinit var contactText:TextView
    lateinit var addressText:TextView
    lateinit var emailText:TextView
    lateinit var passwordText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var name = intent.getStringExtra("name")
        var contact = intent.getStringExtra("contact")
        var address = intent.getStringExtra("address")
        var email = intent.getStringExtra("email")
        var password = intent.getStringExtra("password")

        nameText = findViewById(R.id.nametext_id)
        contactText =findViewById(R.id.contacttext_id)
        addressText = findViewById(R.id.addresstext_id)
        emailText = findViewById(R.id.emailtext_id)
        passwordText = findViewById(R.id.passtext_id)

        nameText.text = name
        contactText.text = contact
        addressText.text = address
        emailText.text = email
        passwordText.text = password

    }
}