package com.example.myfirstapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat.getDateFormat
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity3 : AppCompatActivity() {
//    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var frameLayout: FrameLayout
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)

        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val emailFragment = EmailFragment()
        currentFragment(homeFragment)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_id->currentFragment(homeFragment)
                R.id.search_id->currentFragment(searchFragment)
                R.id.email_id->currentFragment(emailFragment)
            }
            true
        }
//        autoCompleteTextView = findViewById(R.id.autocomplete_id)
//        val countr = arrayOf("India","USA","UK","Australia","Russia")
//        var adapter = ArrayAdapter(this@MainActivity3,android.R.layout.simple_list_item_1,countr)
//        autoCompleteTextView.threshold =0
//        autoCompleteTextView.setAdapter(adapter)
    }

    private fun currentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout_id,fragment)
            commit()
        }
    }
}