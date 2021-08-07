package com.yunis.basictasktracker

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var inputTask: EditText
    private lateinit var mLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mLayout = findViewById(R.id.linearLayout)
        inputTask = findViewById(R.id.TaskInput)
        val taskButton: Button = findViewById(R.id.button)
        taskButton.setOnClickListener(onClick())


    }

    private fun onClick(): View.OnClickListener? {
        return View.OnClickListener {
            mLayout.addView(createNewTextView(inputTask.text.toString()))
        }
    }

    private fun createNewTextView(text: String): TextView? {


        val textView = TextView(this)
        textView.textSize = 20F
        textView.setTextColor(Color.parseColor("#000000"))
        textView.text = text
        return textView
    }
}