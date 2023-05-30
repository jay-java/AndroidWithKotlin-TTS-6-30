package com.example.sqlitedb.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlitedb.Model.StudentModel
import com.example.sqlitedb.R
import com.example.sqlitedb.add_student

class StudentListAdapter(slist: List<StudentModel>, internal var context: Context) :
    RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {
    internal var slist: List<StudentModel> = ArrayList()

    init {
        this.slist = slist
    }

    inner class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name:TextView = view.findViewById(R.id.name_id)
        var details:TextView = view.findViewById(R.id.details_id)
        var edit:Button = view.findViewById(R.id.edit_btn_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.activity_recycler_student_list, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return slist.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val s = slist[position]
        holder.name.text = s.name
        holder.details.text = s.details

        holder.edit.setOnClickListener {
            val i = Intent(context,add_student::class.java)
            i.putExtra("mode","e")
            i.putExtra("id",s.id)
            context.startActivity(i)
        }
    }
}