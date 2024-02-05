package com.example.randy_menu_recursos_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moreButton: ImageView = findViewById(R.id. more_actions_button)
        moreButton.setOnClickListener { view ->
            showMoreActionsMenu(view)
        }
    }
    private fun showMoreActionsMenu(button: View) {
        val popupMenu = PopupMenu(this, button)
        menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
        popupMenu.show()
    }
}