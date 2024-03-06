package com.example.ejemplo_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MyAdapter
    private val myList = ArrayList<String>()
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        adapter = MyAdapter(myList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        val addButton: Button = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            addElement()
        }
    }

    private fun addElement() {
        val newItem = "Item ${myList.size + 1}"
        myList.add(newItem)
        println(newItem.toString())
        adapter.notifyDataSetChanged()

    }

}