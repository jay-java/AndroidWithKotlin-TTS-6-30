package com.example.neww

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Rv_Adapter(var dataList:ArrayList<Rv_Model>,var context:Context):
    RecyclerView.Adapter<Rv_Adapter.MyViewHolder>() {



      class MyViewHolder(item:View):RecyclerView.ViewHolder(item){

        var item_img = item.findViewById<ImageView>(R.id.item_img)
        var item_time = item.findViewById<TextView>(R.id.item_time)
        var item_name = item.findViewById<TextView>(R.id.item_name)
        var item_rating = item.findViewById<TextView>(R.id.item_rating)
        var item_discription = item.findViewById<TextView>(R.id.item_discription)
        var item_discount = item.findViewById<TextView>(R.id.item_discount)
        var item_price = item.findViewById<TextView>(R.id.item_price)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.rv_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
     return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var data = dataList.get(position)

        holder.item_img.setImageResource(data.item_img)
        holder.item_discount.text = data.item_discount
        holder.item_time.text = data.item_time
        holder.item_name.text = data.item_name
        holder.item_discription.text = data.item_discription
        holder.item_rating.text = data.item_rating
        holder.item_price.text = data.item_price



    }
}