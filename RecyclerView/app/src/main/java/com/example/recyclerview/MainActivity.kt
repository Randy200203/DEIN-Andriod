package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler: RecyclerView = findViewById(R.id. recycler)
        recycler.adapter = ColorsAdapter(buildColors())

    }

    private fun buildColors (): List<Color> {
        return listOf(
            Color(getString(R.string. red), getColorHex(R.color. red),"https://loremflickr.com/320/240?random=1" ),
            Color(getString(R.string. indigo), getColorHex(R.color. indigo), "https://loremflickr.com/320/240?random=2" ),
            Color(getString(R.string. green), getColorHex(R.color. green),"https://loremflickr.com/320/240?random=3" ),
            Color(getString(R.string. orange), getColorHex(R.color. orange),"https://loremflickr.com/320/240?random=4" ),
            Color(getString(R.string. blue), getColorHex(R.color. blue),"https://loremflickr.com/320/240?random=5" ),
            Color(getString(R.string. yellow), getColorHex(R.color. yellow),"https://loremflickr.com/320/240?random=6" ),
            Color(getString(R.string. bluegrey), getColorHex(R.color. bluegrey),"https://loremflickr.com/320/240?random=7" ),
            Color(getString(R.string. teal), getColorHex(R.color. teal),"https://loremflickr.com/320/240?random=8" ),
            Color(getString(R.string. deeppurple), getColorHex(R.color. deeppurple),"https://loremflickr.com/320/240?random=9" ),
            Color(getString(R.string. cyan), getColorHex(R.color. cyan),"https://loremflickr.com/320/240?random=10" ),
            Color(getString(R.string. brown), getColorHex(R.color. brown),"https://loremflickr.com/320/240?random=11" ),
            Color(getString(R.string. red), getColorHex(R.color. red),"https://loremflickr.com/320/240?random=12" ),
            Color(getString(R.string. indigo), getColorHex(R.color. indigo), "https://loremflickr.com/320/240?random=13" ),
            Color(getString(R.string. green), getColorHex(R.color. green),"https://loremflickr.com/320/240?random=14" ),
            Color(getString(R.string. orange), getColorHex(R.color. orange),"https://loremflickr.com/320/240?random=15" ),
            Color(getString(R.string. blue), getColorHex(R.color. blue),"https://loremflickr.com/320/240?random=16" ),
            Color(getString(R.string. yellow), getColorHex(R.color. yellow),"https://loremflickr.com/320/240?random=17" ),
            Color(getString(R.string. bluegrey), getColorHex(R.color. bluegrey),"https://loremflickr.com/320/240?random=18" ),
            Color(getString(R.string. teal), getColorHex(R.color. teal),"https://loremflickr.com/320/240?random=19" ),
            Color(getString(R.string. deeppurple), getColorHex(R.color. deeppurple),"https://loremflickr.com/320/240?random=20" ),
            Color(getString(R.string. cyan), getColorHex(R.color. cyan),"https://loremflickr.com/320/240?random=21" ),
            Color(getString(R.string. brown), getColorHex(R.color. brown),"https://loremflickr.com/320/240?random=22" ),
        )
    }
    private fun getColorHex (colorResId: Int): String {
        return String.format("#%06X", 0xFFFFFF and ContextCompat.getColor( this, colorResId))
    }
}


