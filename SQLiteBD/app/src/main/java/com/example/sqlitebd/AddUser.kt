package com.example.sqlitebd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddUser : AppCompatActivity() {
    lateinit var nameEdit:EditText
    lateinit var detailsEditText: EditText
    lateinit var saveBtn:Button
    lateinit var deleteBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        nameEdit = findViewById(R.id.name_id)
        detailsEditText = findViewById(R.id.details_id)
        saveBtn = findViewById(R.id.save_id)
        deleteBtn = findViewById(R.id.delete_id)

        saveBtn.setOnClickListener {

        }
    }
}