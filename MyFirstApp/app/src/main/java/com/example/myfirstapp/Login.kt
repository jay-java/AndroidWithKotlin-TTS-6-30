package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast

class Login : AppCompatActivity() {
    lateinit var  editText:EditText
    lateinit var listView: ListView
    lateinit var spinner:Spinner
    var names = arrayOf("ahmedabad","surat","rajkot","bhavnagar","mehsana","ahmedabad","surat","rajkot","bhavnagar","mehsana","ahmedabad","surat","rajkot","bhavnagar","mehsana")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        editText = findViewById(R.id.email_id)

        listView = findViewById(R.id.listView_id)
        var adapterData = ArrayAdapter(this@Login,android.R.layout.simple_list_item_1,names)
        listView.adapter = adapterData
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this@Login,names[position],Toast.LENGTH_SHORT).show()
        }


        spinner = findViewById(R.id.spinner_id)
        spinner.adapter = adapterData
        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@Login,names[position],Toast.LENGTH_SHORT).show()
//                val name = names[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    fun ButtonClick(view: View) {
        startActivity(Intent(this,MainActivity3::class.java))
    }
}
