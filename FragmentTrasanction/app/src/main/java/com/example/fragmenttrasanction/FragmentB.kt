package com.example.fragmenttrasanction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragmentB : Fragment() {
    var msg : String?=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_b, container, false)
        msg = arguments?.getString("data")
        view.findViewById<TextView>(R.id.textView_id).text = msg
        return  view
    }

}