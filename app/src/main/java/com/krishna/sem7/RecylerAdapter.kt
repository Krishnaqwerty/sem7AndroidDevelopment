package com.krishna.sem7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecylerAdapter(private val context: Context, private val arrayList: ArrayList<LinearPojo>) : RecyclerView.Adapter<RecylerAdapter.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val versionName: TextView = itemView.findViewById(R.id.version_name)
        val version: TextView = itemView.findViewById(R.id.version)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_list, parent, false)
        return MyHolder(view)}

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val currentItem = arrayList[position]
        holder.versionName.text = currentItem.versionName
        holder.version.text = currentItem.version

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }


}