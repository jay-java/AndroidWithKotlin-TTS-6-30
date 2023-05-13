package com.example.fragmenttrasanction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class FragmentA : Fragment() {

    lateinit var communicator:Communicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_a, container, false)
        communicator = activity as Communicator
        view.findViewById<Button>(R.id.btn_id).setOnClickListener {
            communicator.passData(view.findViewById<EditText>(R.id.eidtText_id).text.toString())
        }
        return  view
    }

}