package com.example.firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.w3c.dom.Text

class UserAdapter(val userList:ArrayList<UserModel>):
        RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var mListener:singleUser

    interface singleUser{
        fun onItemClickGet(position: Int)
    }

    fun setOnItemClickListener(clickListener:singleUser){
        mListener =clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.single_user,parent,false)
        return ViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.tvUserName.text = currentUser.userName
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class ViewHolder(itemView:View,clickListener:singleUser):RecyclerView.ViewHolder(itemView) {
        val tvUserName:TextView = itemView.findViewById(R.id.single_text)
        init {
            itemView.setOnClickListener {
                clickListener.onItemClickGet(adapterPosition)
            }
        }
    }
}