package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    lateinit var radioGroup:RadioGroup
    lateinit var maleRadio:RadioButton
    lateinit var femaleRadio:RadioButton
    lateinit var check1:CheckBox
    lateinit var check2:CheckBox
    lateinit var switch: Switch
    lateinit var seekBar: SeekBar
    lateinit var seekBarText:TextView
    lateinit var seekBarTextChange:TextView
    var start = 0
    var end = 0
    lateinit var ratingBar: RatingBar
    lateinit var ratingBarText:TextView
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

        check1 = findViewById(R.id.checkbox1_id)
        check2 = findViewById(R.id.checkbox2_id)
        check1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Toast.makeText(this@MainActivity3,"Cricket",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@MainActivity3,"Cricket removed",Toast.LENGTH_SHORT).show()
            }
        }
        check2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Toast.makeText(this@MainActivity3,"Hokey",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@MainActivity3,"Hokey removed",Toast.LENGTH_SHORT).show()
            }
        }

        switch = findViewById(R.id.switch_id)
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Toast.makeText(this@MainActivity3,"Switch On",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@MainActivity3,"Switch Off",Toast.LENGTH_SHORT).show()
            }
        }

        seekBar = findViewById(R.id.seekbar_id)
        seekBarText = findViewById(R.id.seekbar_text_id)
        seekBarTextChange = findViewById(R.id.seekbar_text_change_id)
        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBarText.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if(seekBar!=null){
                    start = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if(seekBar!=null){
                    end = seekBar.progress
                    Toast.makeText(this@MainActivity3,"Progress : ${end-start}",Toast.LENGTH_SHORT).show()
                    seekBarTextChange.text = "Progress : ${end-start}"
                }
            }
        })

        ratingBar = findViewById(R.id.ratingBar_id)
        ratingBarText = findViewById(R.id.ratingBar_text_id)
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            ratingBarText.text = rating.toString()
        }

    }
}