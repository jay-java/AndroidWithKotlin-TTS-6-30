package com.example.firebaseproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val userList:ArrayList<UserModel>,var context:Context):RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_user,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var user = userList[position]
        holder.userName.text = user.userName

        holder.raw_card.setOnClickListener {

            var i = Intent(context.applicationContext,ShowDataActivity::class.java)
            i.putExtra("name",user.userName.toString())
           // i.putExtra("email",user.userEmail.toString())
           // i.putExtra("contact",user.userContact.toString())
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName:TextView = itemView.findViewById(R.id.single_user_text_id)
        val raw_card:CardView = itemView.findViewById(R.id.raw_card)
    }
}