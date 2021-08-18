package com.yunis.basictasktracker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class MainActivity : AppCompatActivity() {
    private lateinit var inputTask: TextView
    private lateinit var updateTask: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        inputTask = findViewById(R.id.TaskInput)
        updateTask = findViewById(R.id.updateItem)

        val taskButton: Button = findViewById(R.id.button)
        val clearButton: Button = findViewById(R.id.button2)
        val updateButton: Button = findViewById(R.id.button3)


        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val taskList = mutableListOf<Any>()

        val adapter = RecyclerViewAdapter(taskList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        taskButton.setOnClickListener {

            taskList.add(inputTask.text.toString())
            adapter.notifyDataSetChanged()


        }
        updateButton.setOnClickListener {
            taskList[updateTask.text.toString().toInt() - 1] = inputTask.text.toString()

            adapter.notifyDataSetChanged()
        }


        val itemDecoration: ItemDecoration =
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)

        clearButton.setOnClickListener {
            taskList.clear()

            adapter.notifyDataSetChanged()

        }


    }


}