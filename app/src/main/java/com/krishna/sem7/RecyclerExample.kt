package com.krishna.sem7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerExample : AppCompatActivity() {

    private lateinit var recyclerViewLinear: RecyclerView

    var recylerAdapter: RecylerAdapter? = null

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var arrayList: ArrayList<LinearPojo>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_example)

        linearListData()
        initRecyclerView()


    }

    private fun linearListData(){
        arrayList = ArrayList()
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 13", "API 32"))
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 13", "API 32"))
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 13", "API 32"))
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 13", "API 32"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 13", "API 32"))
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 13", "API 32"))
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 13", "API 32"))
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 13", "API 32"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 13", "API 32"))
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 13", "API 32"))
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 13", "API 32"))
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 10", "API 29"))
        arrayList.add(LinearPojo("Android 11", "API 30"))
        arrayList.add(LinearPojo("Android 12", "API 31"))
        arrayList.add(LinearPojo("Android 13", "API 32"))

        }

    private fun initRecyclerView(){
        recyclerViewLinear = findViewById(R.id.recyclerViewLinear)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerViewLinear.layoutManager = linearLayoutManager

        recylerAdapter = RecylerAdapter(this, arrayList)
        recyclerViewLinear.adapter = recylerAdapter

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val deletedItem = arrayList[position]
                arrayList.removeAt(position)


                recylerAdapter?.notifyItemRemoved(position)

                Snackbar.make(recyclerViewLinear, "${deletedItem.versionName} Deleted", Snackbar.LENGTH_LONG)
                    .setAction("Undo", {
                        arrayList.add(position, deletedItem)
                        recylerAdapter?.notifyItemInserted(position)
                    }).show()


            }



        }).attachToRecyclerView(recyclerViewLinear)








    }











}