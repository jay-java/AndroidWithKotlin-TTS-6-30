package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var login:TextView
    lateinit var btn:Button
    lateinit var submitBtn:Button
    lateinit var name:EditText
    lateinit var contact:EditText
    lateinit var address:EditText
    lateinit var email:EditText
    lateinit var password:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name_id)
        contact = findViewById(R.id.contact_id)
        address = findViewById(R.id.address_id)
        email = findViewById(R.id.email_id)
        password = findViewById(R.id.password_id)

        submitBtn = findViewById(R.id.submit_btn_id)
        submitBtn.setOnClickListener(View.OnClickListener {
            var intent = Intent(this@MainActivity,Home::class.java)
            intent.putExtra("name",name.text.toString())
            intent.putExtra("contact",contact.text.toString())
            intent.putExtra("address",address.text.toString())
            intent.putExtra("email",email.text.toString())
            intent.putExtra("password",password.text.toString())
            startActivity(intent)
        })

        login = findViewById(R.id.login_id)
        login.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Login::class.java))
            Toast.makeText(this,"Login Acticity",Toast.LENGTH_LONG).show()
        })

        btn = findViewById(R.id.btn_id)
        registerForContextMenu(btn)

        btn.setOnClickListener(View.OnClickListener {
            var popup = PopupMenu(this, btn)
            popup.menuInflater.inflate(R.menu.popup_menu,popup.menu)
            popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {
                item ->
                when(item.itemId){
                    R.id.home_id->Toast.makeText(this@MainActivity,"Home",Toast.LENGTH_SHORT).show()
                    R.id.setting_id->Toast.makeText(this@MainActivity,"Setting",Toast.LENGTH_SHORT).show()
                    R.id.search_id->Toast.makeText(this@MainActivity,"Search",Toast.LENGTH_SHORT).show()
                    R.id.edit_id->Toast.makeText(this@MainActivity,"Edit",Toast.LENGTH_SHORT).show()
                }
                true
            })
            popup.show()
        })
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home_id->Toast.makeText(this@MainActivity,"Home",Toast.LENGTH_SHORT).show()
            R.id.setting_id->Toast.makeText(this@MainActivity,"Setting",Toast.LENGTH_SHORT).show()
            R.id.edit_id->Toast.makeText(this@MainActivity,"Edit",Toast.LENGTH_SHORT).show()
            R.id.search_id->Toast.makeText(this@MainActivity,"sEARCH",Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home_id->Toast.makeText(this@MainActivity,"Home",Toast.LENGTH_SHORT).show()
            R.id.setting_id->Toast.makeText(this@MainActivity,"Setting",Toast.LENGTH_SHORT).show()
            R.id.edit_id->Toast.makeText(this@MainActivity,"Edit",Toast.LENGTH_SHORT).show()
            R.id.search_id->Toast.makeText(this@MainActivity,"sEARCH",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}