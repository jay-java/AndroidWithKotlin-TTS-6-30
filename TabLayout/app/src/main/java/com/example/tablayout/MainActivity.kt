package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tablayout:TabLayout
    lateinit var viewPager:ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tablayout = findViewById(R.id.talayout_id)
        viewPager = findViewById(R.id.viewpager_id)

        setTabs()
    }

    private fun setTabs() {
        val adapter  = ViewPagerAdapater(supportFragmentManager)

        adapter.addFragment(ChatFragment(),"Chat")
        adapter.addFragment(StatusFragment(),"Status")
        adapter.addFragment(CallFragment(),"Calls")
        viewPager.adapter = adapter
        tablayout.setupWithViewPager(viewPager)

    }

}