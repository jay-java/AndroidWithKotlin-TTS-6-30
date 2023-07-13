package com.example.firebase

import android.content.Intent
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.FirebaseDatabase

class getsingleuser : AppCompatActivity() {
    private lateinit var tvId:TextView
    private lateinit var tvName:TextView
    private lateinit var tvContact:TextView
    private lateinit var tvAddress:TextView
    private lateinit var tvEmail:TextView
    private lateinit var tvPassword:TextView
    private lateinit var updateBTN:Button
    private lateinit var deleteBTN:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getsingleuser)

        tvId = findViewById(R.id.id_text)
        tvName = findViewById(R.id.name_text)
        tvContact = findViewById(R.id.contact_text)
        tvAddress = findViewById(R.id.address_text)
        tvEmail = findViewById(R.id.email_text)
        tvPassword = findViewById(R.id.password_text)
        updateBTN = findViewById(R.id.update_BTN)
        deleteBTN = findViewById(R.id.delete_BTN)
        initView()
        setValuesTOView()

        updateBTN.setOnClickListener {
            openUpdateDialogue(
                intent.getStringExtra("id").toString(),
                intent.getStringExtra("name").toString()
            )
        }

        deleteBTN.setOnClickListener {
            deleteData(
                intent.getStringExtra("id").toString()
            )
        }
    }

    private fun deleteData(id:String){
        val dbref = FirebaseDatabase.getInstance().getReference("users").child(id)
        val task = dbref.removeValue()
        task.addOnSuccessListener {
            Toast.makeText(this@getsingleuser,"deleted",Toast.LENGTH_SHORT).show()
            val i = Intent(this@getsingleuser,UsersList::class.java)
            finish()
            startActivity(i)
        }
        task.addOnFailureListener {error->
            Toast.makeText(this@getsingleuser,"error ${error.message}",Toast.LENGTH_SHORT).show()
        }

    }

    private fun initView() {

    }
    private fun setValuesTOView(){
        tvId.text = intent.getStringExtra("name")
        tvName.text = intent.getStringExtra("name")
        tvContact.text = intent.getStringExtra("contact")?.toLong().toString()
        tvAddress.text = intent.getStringExtra("address")
        tvEmail.text = intent.getStringExtra("email")
        tvPassword.text = intent.getStringExtra("password")
    }

    private fun openUpdateDialogue(userId: String, userName: String) {
        val dialogue = AlertDialog.Builder(this)
        val inflator = layoutInflater
        val dialogueView = inflator.inflate(R.layout.activity_update_user_dialogue,null)

        dialogue.setView(dialogueView)
        val uName = dialogueView.findViewById<EditText>(R.id.update_name_text)
        val uContact = dialogueView.findViewById<EditText>(R.id.update_contact_text)
        val uAddress = dialogueView.findViewById<EditText>(R.id.update_address_text)
        val uEmail = dialogueView.findViewById<EditText>(R.id.update_email_text)
        val uPassword = dialogueView.findViewById<EditText>(R.id.update_password_text)
        val updateBTNView = dialogueView.findViewById<Button>(R.id.update_user_BTN)

        uName.setText(intent.getStringExtra("name").toString())
        uContact.setText(intent.getStringExtra("contact").toString())
        uAddress.setText(intent.getStringExtra("address").toString())
        uEmail.setText(intent.getStringExtra("email").toString())
        uPassword.setText(intent.getStringExtra("password").toString())

        dialogue.setTitle("update data")
        val alertDialogue = dialogue.create()
        alertDialogue.show()

        updateBTNView.setOnClickListener {
            updateData(
                userId,
                uName.text.toString(),
                uContact.text.toString().toLong(),
                uAddress.text.toString(),
                uEmail.text.toString(),
                uPassword.text.toString()
            )
            Toast.makeText(applicationContext,"updated",Toast.LENGTH_SHORT).show()
            tvName.text = uName.text.toString()
            tvContact.text = uContact.text.toString().toLong().toString()
            tvAddress.text = uAddress.text.toString()
            tvEmail.text = uEmail.text.toString()
            tvPassword.text = uPassword.text.toString()
            alertDialogue.dismiss()
        }
    }

    private fun updateData(
        id:String,
        name:String,
        contact:Long,
        address:String,
        email:String,
        password:String
    ){
        val dbref= FirebaseDatabase.getInstance().getReference("users").child(id)
        val userInfo = UserModel(id,name,contact,address,email,password)
        dbref.setValue(userInfo)
    }

}