package com.example.myfirstapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat.getDateFormat
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.util.*

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
    lateinit var alertBTN:Button
    lateinit var dateBTN:Button
    lateinit var timeBTN:Button
    lateinit var dateText:TextView
    lateinit var timeText:TextView
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

        alertBTN = findViewById(R.id.alert_btn_id)
        alertBTN.setOnClickListener(View.OnClickListener {
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Alert")
            alert.setMessage("Are you sure ? ")
            alert.setPositiveButton(android.R.string.yes){dialogue,which->
                Toast.makeText(this@MainActivity3,"Yes",Toast.LENGTH_SHORT).show()
            }

            alert.setNegativeButton(android.R.string.no){
                dialogue,which->
                Toast.makeText(this@MainActivity3,"No",Toast.LENGTH_SHORT).show()
            }

            alert.setNeutralButton("Maybe"){
                dialogue,which->
                Toast.makeText(this@MainActivity3,"Maybe later",Toast.LENGTH_SHORT).show()
            }
            alert.show()
        })

        var calender= Calendar.getInstance();
        var year=calender.get(Calendar.YEAR);
        var month=calender.get(Calendar.MONTH);
        var day=calender.get(Calendar.DAY_OF_MONTH)

        dateBTN = findViewById(R.id.date_btn_id)
        dateBTN.setOnClickListener(View.OnClickListener {
            var dpd=
                DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(this@MainActivity3,"$dayOfMonth/$month/$year",Toast.LENGTH_SHORT).show()
            },year,month
                ,day)
            dpd.show()
        })


        var mTimePicker: TimePickerDialog
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
        val minute = mcurrentTime.get(Calendar.MINUTE)
        timeBTN = findViewById(R.id.time_btn_id)
        timeText = findViewById(R.id.time_text_id)
        timeBTN.setOnClickListener(View.OnClickListener {
            mTimePicker = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    Toast.makeText(this@MainActivity3,"$hourOfDay/$minute",Toast.LENGTH_SHORT).show()
                }
            }, hour, minute, false)
            mTimePicker.show()
        })
    }
}