package com.example.firebase

import android.content.Intent
import android.opengl.Visibility
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
import org.w3c.dom.Text

class UsersList : AppCompatActivity() {
    private lateinit var usersRecyclerView: RecyclerView
    private lateinit var tvLoadingData:TextView
    private lateinit var userList:ArrayList<UserModel>
    private lateinit var dbref:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list)
        usersRecyclerView = findViewById(R.id.recyclerView_id)
        usersRecyclerView.layoutManager = LinearLayoutManager(this)
        usersRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.loading_text)

        userList = arrayListOf<UserModel>()
        getUsersData()
    }

    private fun getUsersData() {
        usersRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        dbref = FirebaseDatabase.getInstance().getReference("users")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                if(snapshot.exists()){
                    for(user in snapshot.children){
                        val userData =user.getValue(UserModel::class.java)
                        userList.add(userData!!)
                    }
                    val userAdapter = UserAdapter(userList)
                    usersRecyclerView.adapter = userAdapter

                    userAdapter.setOnItemClickListener(object : UserAdapter.singleUser{
                        override fun onItemClickGet(position: Int) {
                            val i = Intent(this@UsersList,getsingleuser::class.java)
                            i.putExtra("id",userList[position].userId)
                            i.putExtra("name",userList[position].userName)
                            i.putExtra("contact",userList[position].userContact.toString())
                            i.putExtra("address",userList[position].userAddress)
                            i.putExtra("email",userList[position].userEmail)
                            i.putExtra("password",userList[position].userPassword)
                            startActivity(i)
                        }
                    })

                    usersRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@UsersList,"error",Toast.LENGTH_SHORT).show()
            }
        })
    }
}