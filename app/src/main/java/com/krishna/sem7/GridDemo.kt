package com.krishna.sem7

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.krishna.sem7.GridItemData

class GridDemo : AppCompatActivity() {

    private lateinit var gridView : GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid_demo)

        val gridView = findViewById<GridView>(R.id.gridView)

        val items = listOf(

            GridItemData("Apple", R.drawable.a),
            GridItemData("Tomato", R.drawable.b)

        )

        val adapter = GridAdapter(this, items)

        gridView.adapter = adapter







    }
}