package com.krishna.sem7

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val list = mutableListOf<Model>()

        list.add(Model("Facebook", "It's a social media app", R.drawable.facebook))
        list.add(Model("Title 2", "Description 2", R.drawable.a))
        list.add(Model("Title 3", "Description 3", R.drawable.b))
        list.add(Model("Title 4", "Description 4", R.drawable.c))
        list.add(Model("Title 5", "Description 5", R.drawable.d))
        list.add(Model("Title 6", "Description 6", R.drawable.e))
        list.add(Model("Title 7", "Description 7", R.drawable.g))
        list.add(Model("Title 8", "Description 8", R.drawable.h))
        list.add(Model("Title 9", "Description 9", R.drawable.facebook))
        list.add(Model("Title 10", "Description 10", R.drawable.facebook))
        list.add(Model("Title 11", "Description 11", R.drawable.facebook))
        list.add(Model("Title 12", "Description 12", R.drawable.facebook))

        listView.adapter = MyAdapter(this, R.layout.listview, list)


//        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
//            if (position == 0) {
//                // Handle item click here
//                val intent = Intent(this, MainActivity2::class.java)
//                startActivity(intent)
//
//            }
//            }



    }
}