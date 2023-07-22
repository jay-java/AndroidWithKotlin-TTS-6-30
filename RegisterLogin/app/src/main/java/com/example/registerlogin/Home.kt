package com.example.registerlogin

import android.content.Context
import android.content.Intent
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

        val sharedPreferences = this?.getPreferences(Context.MODE_PRIVATE)?:return
        val isLogin = sharedPreferences.getString("email","1")
        val email = intent.getStringExtra("email")

        logoutBTN = findViewById(R.id.logout_btn_id)
        logoutBTN.setOnClickListener {
            sharedPreferences.edit().remove("email").apply()
            val i = Intent(this,Login::class.java)
            startActivity(i)
            finish()
        }

        if(isLogin == "1"){
            var email = intent.getStringExtra("email")
            if(email!=null){
                setData(email)
                with(sharedPreferences.edit()) {
                    putString("email", email)
                    apply()
                }
            }
            else{
                val i = Intent(this,Login::class.java)
                startActivity(i)
                finish()
            }
        }
        else{
            setData(isLogin)
        }
    }
    private fun setData(email: String?) {
        firebaseFireStore = FirebaseFirestore.getInstance()
        if (email != null) {
            firebaseFireStore.collection("users").document(email).get()
                .addOnSuccessListener { task->
                    nameTextView.text = task.get("name").toString()
                    contactTextView.text = task.get("contact").toString()
                    emailTextView.text = task.get("email").toString()
                    passwordTextView.text = task.get("password").toString()
                }
        }

    }
}