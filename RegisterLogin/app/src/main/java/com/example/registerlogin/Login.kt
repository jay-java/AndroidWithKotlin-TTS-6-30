package com.example.registerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginBTN: Button
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        emailEditText = findViewById(R.id.email_login_id)
        passwordEditText = findViewById(R.id.password_login_id)
        loginBTN = findViewById(R.id.login_btn_id)

        auth = FirebaseAuth.getInstance()
        loginBTN.setOnClickListener {
            var email = emailEditText.text.toString()
            var password = passwordEditText.text.toString()
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val i = Intent(this, Home::class.java)
                        i.putExtra("email", email)
                        startActivity(i)
                        finish()
                    } else {
                        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}