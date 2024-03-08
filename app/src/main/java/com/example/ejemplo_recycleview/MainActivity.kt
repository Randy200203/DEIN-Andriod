package com.example.ejemplo_recycleview

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplo_recycleview.MyAdapter
import com.example.ejemplo_recycleview.R

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MyAdapter
    private val myList = ArrayList<String>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var editTextBuscar: EditText

    @SuppressLint("MissingInflatedId", "ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        editTextBuscar = findViewById(R.id.editTextBuscar)
        editTextBuscar.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
        editTextBuscar.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_search_24, 0, 0, 0)

        adapter = MyAdapter(myList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val addButton: Button = findViewById(R.id.addButton)
        addButton.setOnClickListener {
            addElement()
        }

        // Agregar el TextWatcher para manejar el EditText
        editTextBuscar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Ocultar el ícono de búsqueda y mostrar el ícono de cancelar
                if (s?.length ?: 0 > 0) {
                    editTextBuscar.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                    editTextBuscar.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.asset_cancel, 0)
                } else {
                    editTextBuscar.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                    editTextBuscar.setCompoundDrawablesWithIntrinsicBounds(R.drawable.baseline_search_24, 0, 0, 0)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        // Agregar el OnClickListener para el ícono de cancelar
        editTextBuscar.setOnTouchListener { v, event ->
            val DRAWABLE_RIGHT = 2
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = (v as EditText).compoundDrawables[DRAWABLE_RIGHT]
                if (drawableEnd != null && event.rawX >= v.right - drawableEnd.bounds.width()) {
                    // Borrar el texto cuando se hace clic en el ícono de cancelar
                    editTextBuscar.text.clear()
                    return@setOnTouchListener true
                }
            }
            return@setOnTouchListener false
        }
    }

    private fun addElement() {
        val newItem = "Item ${myList.size + 1}"
        myList.add(newItem)
        println(newItem.toString())
        adapter.notifyDataSetChanged()
    }
}