package com.example.neww

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class MainActivity : AppCompatActivity() {

    lateinit var rv:RecyclerView
    lateinit var adapter:Rv_Adapter
    lateinit var dataList:ArrayList<Rv_Model>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)
        dataList = ArrayList<Rv_Model>()

        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)

        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))
        dataList.add(Rv_Model(R.drawable.sandwich,"50% Off Up To 100","21 Min","Cheese Sandwich","4.3*","Sandwich,Pizza ...","$150 For One"))

        adapter = Rv_Adapter(dataList,this)
        rv.adapter = adapter



    }
}