package com.example.sqlitebd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddUser : AppCompatActivity() {
    lateinit var nameEdit:EditText
    lateinit var detailsEditText: EditText
    lateinit var saveBtn:Button
    lateinit var deleteBtn:Button
    var dbHandler : DBHelper?= null
    var isEditMode:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        nameEdit = findViewById(R.id.name_id)
        detailsEditText = findViewById(R.id.details_id)
        saveBtn = findViewById(R.id.save_id)
        deleteBtn = findViewById(R.id.delete_id)
        dbHandler = DBHelper(this)
        saveBtn.setOnClickListener {
            var succes:Boolean = false
            var model:Model = Model()
            model.name = nameEdit.text.toString()
            model.details = detailsEditText.text.toString()

           succes =  dbHandler?.addUser(model) as Boolean
            if(succes) {
                var i = Intent(this@AddUser,MainActivity::class.java)
                startActivity(i)
                finish()
            }
            else{
                Toast.makeText(this@AddUser,"error",Toast.LENGTH_SHORT).show()
            }
        }
    }
}