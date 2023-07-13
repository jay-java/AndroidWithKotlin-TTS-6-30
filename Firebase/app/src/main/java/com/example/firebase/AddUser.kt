package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddUser : AppCompatActivity() {
    private lateinit var nameED: EditText
    private lateinit var contactED: EditText
    private lateinit var addressED: EditText
    private lateinit var emailED: EditText
    private lateinit var passwordED: EditText
    private lateinit var saveBTN: Button
    private lateinit var dbref: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        nameED = findViewById(R.id.name_id)
        contactED = findViewById(R.id.contact_id)
        addressED = findViewById(R.id.address_id)
        emailED = findViewById(R.id.email_id)
        passwordED = findViewById(R.id.password_id)
        saveBTN = findViewById(R.id.save_id)

        dbref = FirebaseDatabase.getInstance().getReference("users")
        saveBTN.setOnClickListener {
            saveUserData()
        }
    }

    private fun saveUserData() {
        val name = nameED.text.toString()
        val contact: Long = contactED.text.toString().toLong()
        val address = addressED.text.toString()
        val email = emailED.text.toString()
        val password = passwordED.text.toString()
        if (name.isEmpty()) {
            nameED.error = "please enter name"
        }
        if (contact.toString().length != 10) {
            contactED.error = "please enter correct contact"
        }
        if (address.isEmpty()) {
            addressED.error = "please enter address"
        }
        if (email.isEmpty()) {
            emailED.error = "please enter email"
        }
        if (password.isEmpty()) {
            passwordED.error = "please enter password"
        }

        val id = dbref.push().key!!
        val user = UserModel(id, name, contact, address, email, password)
        dbref.child(id).setValue(user)
            .addOnCompleteListener {
                Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show()
                nameED.text.clear()
                contactED.text.clear()
                addressED.text.clear()
                emailED.text.clear()
                passwordED.text.clear()
            }
            .addOnFailureListener {err->
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
            }
    }
}