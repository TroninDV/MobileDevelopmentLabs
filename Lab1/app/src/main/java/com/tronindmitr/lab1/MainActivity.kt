package com.tronindmitr.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.counter_text)
        text.text = "0"
        var currentCounter = 0

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            currentCounter++
            text.text = currentCounter.toString()
        }
    }
}