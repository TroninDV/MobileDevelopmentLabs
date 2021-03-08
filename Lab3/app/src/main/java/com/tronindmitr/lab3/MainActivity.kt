package com.tronindmitr.lab3

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var counterButton: Button
    var currentButtonState = false
    var currentButtonCount: Int = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.button_state)
        counterButton = findViewById(R.id.counter_button)
        val stateButton = findViewById<Button>(R.id.state_button)
        val date_selection = findViewById<Button>(R.id.date_selection)
        val time_selection = findViewById<Button>(R.id.time_selection)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val seek = findViewById<SeekBar>(R.id.seekBar)
        val switcher = findViewById<SwitchMaterial>(R.id.switch_text)
        val seek_text = findViewById<TextView>(R.id.seek_text)

        counterButton.setOnClickListener {
            ++currentButtonCount
            counterButton.text = "Счетчик: " + currentButtonCount.toString()
        }
        switcher.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switcher.text = "Включен"
            } else {
                switcher.text = "Выключен"
            }
        }


        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seek_text.text = "Текущее значение " + progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        val arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            arrayOf("Первый вариант", "Второй вариант", "Третий вариант")
        )
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("Task_output", parent?.getItemAtPosition(position).toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        stateButton.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                textView.text = "Нажата"
            } else if (event.action == MotionEvent.ACTION_UP) {
                textView.text = "Отпущена"
                v.performClick()
            }
            false
        }

        date_selection.setOnClickListener { v ->
            val datePickerDialog = DatePickerDialog(v.context, { _, year, month, dayOfMonth ->
                Log.d("Task_output", "Chosen date isf %d.%d.%d".format(dayOfMonth, month, year))
            }, 2021, 1, 1)
            datePickerDialog.show()
        }

        time_selection.setOnClickListener { v ->
            val timePickerDialog = TimePickerDialog(v.context, { _, hourOfDay, minute ->
                Log.d("Task_output", "Chosen time is %d:%d".format(hourOfDay, minute))
            }, 9, 0, false)
            timePickerDialog.show()
        }

    }
}
