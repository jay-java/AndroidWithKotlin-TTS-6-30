package com.example.registerlogin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class Home : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var contactTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var passwordTextView: TextView
    private lateinit var logoutBTN:Button
    private lateinit var firebaseFireStore:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        nameTextView = findViewById(R.id.name_text_id)
        contactTextView = findViewById(R.id.contact_text_id)
        emailTextView = findViewById(R.id.email_text_id)
        passwordTextView = findViewById(R.id.password_text_id)
        logoutBTN = findViewById(R.id.logout_btn_id)

        val sharedPreferences = this?.getSharedPreferences(Context.MODE_PRIVATE)?:return
    }
}