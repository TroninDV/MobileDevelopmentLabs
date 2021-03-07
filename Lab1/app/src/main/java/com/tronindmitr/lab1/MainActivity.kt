package com.tronindmitr.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var currentCounter = 0
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.counter_text)
        text.text = "0"
    }

    fun incrementOnClick(view: View) {
        currentCounter++
        text.text = currentCounter.toString()
    }


}