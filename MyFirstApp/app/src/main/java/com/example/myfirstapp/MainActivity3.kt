package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    lateinit var radioGroup:RadioGroup
    lateinit var maleRadio:RadioButton
    lateinit var femaleRadio:RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        radioGroup = findViewById(R.id.radiogroup_id)
        maleRadio = findViewById(R.id.male_id)
        femaleRadio = findViewById(R.id.female_id)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.male_id->Toast.makeText(this,"Male",Toast.LENGTH_LONG).show()
                R.id.female_id->Toast.makeText(this,"Female",Toast.LENGTH_LONG).show()
            }
        }
    }
}