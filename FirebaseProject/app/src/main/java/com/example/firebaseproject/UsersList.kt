package com.example.firebaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UsersList : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var loadingText:TextView
    private lateinit var userList:ArrayList<UserModel>
    private lateinit var dbref:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list)
        recyclerView = findViewById(R.id.recyclerView_id)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        loadingText = findViewById(R.id.loading_textView_id)

        userList = ArrayList<UserModel>()
        dbref = FirebaseDatabase.getInstance().getReference("users")

        loadingText.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        dbref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                if(snapshot.exists()){
                    for(user in snapshot.children){
                        var userData = user.getValue(UserModel::class.java)
                        userList.add(userData!!)
                    }
                    var adapter = UserAdapter(userList)
                    recyclerView.adapter = adapter

                    loadingText.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@UsersList,"error",Toast.LENGTH_SHORT).show()
            }

        })
    }
}