package com.example.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var drawerLayout:DrawerLayout
    lateinit var navigationView:NavigationView
    lateinit var frameLayout: FrameLayout
    lateinit var toolbar: Toolbar
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerlayout_id)
        navigationView = findViewById(R.id.navigation_view_id)
        frameLayout = findViewById(R.id.framelayout_id)
        toolbar= findViewById(R.id.toolbar_id)
        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            toolbar,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout_id, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.home_id)
        }

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_id->supportFragmentManager.beginTransaction().replace(R.id.framelayout_id,HomeFragment()).commit()
                R.id.settings_id->supportFragmentManager.beginTransaction().replace(R.id.framelayout_id,SettingsFragment()).commit()
                R.id.mail_id->supportFragmentManager.beginTransaction().replace(R.id.framelayout_id,MailFragment()).commit()
                R.id.share_id->supportFragmentManager.beginTransaction().replace(R.id.framelayout_id,ShareFragment()).commit()
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true

        }
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            onBackPressedDispatcher.onBackPressed()
        }
    }
}