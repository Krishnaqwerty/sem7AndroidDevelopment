package com.krishna.sem7

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ListView



class What : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_what)


        val viewMain = findViewById<ListView>(R.id.listViewForStatus)





        val items = listOf(

            StatusData("Tannu", "15 min ago, 3:00", R.drawable.c)




        )

        val adapter = StatusAdapter(this, items)


        viewMain.adapter = adapter




    }
}