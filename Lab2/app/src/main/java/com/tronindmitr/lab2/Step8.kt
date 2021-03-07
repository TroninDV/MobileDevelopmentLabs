package com.tronindmitr.lab2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Step8 : Fragment() {

    lateinit var first_sum: TextView
    lateinit var second_sum: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_step8, container, false)

        first_sum = view.findViewById(R.id.first_sum)
        second_sum = view.findViewById(R.id.second_sum)

        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val number = first_sum.text.toString().toDouble() + second_sum.text.toString().toDouble()
            Toast.makeText(activity, number.toString(), Toast.LENGTH_SHORT).show()
            Log.d("Result", number.toString())
        }
        return view
    }

}