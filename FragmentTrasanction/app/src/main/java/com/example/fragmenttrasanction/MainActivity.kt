package com.example.fragmenttrasanction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = FragmentA()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout_id,fragmentA).commit()
    }

    override fun passData(msg: String) {
        val bundle = Bundle()
        bundle.putString("data",msg)

        var tx = supportFragmentManager.beginTransaction()
        val fragmentB = FragmentB()
        fragmentB.arguments = bundle

        tx.replace(R.id.frameLayout_id, fragmentB)
        tx.commit()
    }
}