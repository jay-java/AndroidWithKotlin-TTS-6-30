package com.example.apitest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PostAdapter(val postModel:MutableList<PostModel>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_raw,parent,false)
        return  PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postModel.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return holder.bindView(postModel[position])
    }

}

class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private  val userId: TextView = itemView.findViewById(R.id.user_id)
    private val name: TextView = itemView.findViewById(R.id.name)
    private val type: TextView = itemView.findViewById(R.id.type)
    private val avatarUrl:ImageView = itemView.findViewById(R.id.image_id)
    fun bindView(postModel:PostModel){
        userId.text = postModel.id.toString()
        name.text = postModel.login
        type.text = postModel.type
        Picasso.get().load(postModel.avatar_url).into(avatarUrl)
    }
}