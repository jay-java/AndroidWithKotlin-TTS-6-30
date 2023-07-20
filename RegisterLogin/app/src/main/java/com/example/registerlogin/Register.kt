package com.example.registerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Register : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var contactEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerBTN: Button
    private lateinit var auth:FirebaseAuth
    private lateinit var firebaseFireStore:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        nameEditText = findViewById(R.id.name_id)
        contactEditText = findViewById(R.id.contact_id)
        emailEditText = findViewById(R.id.email_id)
        passwordEditText = findViewById(R.id.passwrod_id)
        registerBTN = findViewById(R.id.register_btn_id)
        auth = FirebaseAuth.getInstance()
        firebaseFireStore = FirebaseFirestore.getInstance()
        registerBTN.setOnClickListener {
            var name:String = nameEditText.text.toString()
            var contact = contactEditText.text.toString()
            var email = emailEditText.text.toString()
            var password = passwordEditText.text.toString()

            var user = hashMapOf(
                "name" to name,
                "contact" to contact,
                "email" to email,
                "password" to password
            )

            val users = firebaseFireStore.collection("users")
            val q = users.whereEqualTo("email",email).get()
                .addOnSuccessListener {
                    task->
                    if(task.isEmpty){
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener {
                                task->
                                if(task.isSuccessful){
                                    users.document(email).set(user)
                                    val i = Intent(this,Home::class.java)
                                    i.putExtra("email",email)
                                    startActivity(i)
                                    finish()
                                }
                                else{
                                    Toast.makeText(this,"something went wrong",Toast.LENGTH_SHORT).show()
                                }
                            }
                    }
                    else{
                        Toast.makeText(this,"user already registered",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}