package com.example.firebaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.lang.ref.Reference

class add_user : AppCompatActivity() {
    private lateinit var nameED:EditText
    private lateinit var contactED:EditText
    private lateinit var addressED:EditText
    private lateinit var emailED:EditText
    private lateinit var passwordED:EditText
    private lateinit var SaveBTN:Button
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        nameED = findViewById(R.id.name_id)
        contactED = findViewById(R.id.contact_id)
        addressED = findViewById(R.id.address_id)
        emailED = findViewById(R.id.email_id)
        passwordED  =findViewById(R.id.password_id)
        SaveBTN = findViewById(R.id.addUserBTN_id)
        databaseReference = FirebaseDatabase.getInstance().getReference("users")

        SaveBTN.setOnClickListener {
            saveUsers()
        }
    }

    private fun saveUsers() {
        var name = nameED.text.toString()
        var contact:Long = contactED.text.toString().toLong()
        var address = addressED.text.toString()
        var email = emailED.text.toString()
        var password = passwordED.text.toString()

        if(name.isEmpty()){
            nameED.error = "please enter name"
        }
        if(contact.toString().length!=10){
            contactED.error = "please enter contact"
        }
        if(address.isEmpty()){
            addressED.error = "please enter address"
        }
        if(email.isEmpty()){
            emailED.error = "please enter email"
        }
        if(password.isEmpty()){
            passwordED.error = "please enter password"
        }

        var id = databaseReference.push().key!!
        var user = UserModel(id,name,contact,address,email,password)
        databaseReference.child(id).setValue(user)
            .addOnCompleteListener {
                Toast.makeText(this,"data inserted",Toast.LENGTH_SHORT).show()
                nameED.text.clear()
                contactED.text.clear()
                addressED.text.clear()
                emailED.text.clear()
                passwordED.text.clear()
            }
            .addOnFailureListener { err->
                Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
            }

    }
}