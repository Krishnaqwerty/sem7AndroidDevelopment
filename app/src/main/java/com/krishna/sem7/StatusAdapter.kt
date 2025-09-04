package com.krishna.sem7


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class StatusAdapter(private val context: Context , private var item:List<StatusData>) : BaseAdapter()

{

    private val inflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return item.size
    }

    override fun getItem(position: Int): Any? {

        return item[position]

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {

        val rowView = convertView ?: inflater.inflate(R.layout.statuslist, parent, false)
        val image = rowView.findViewById<ImageView>(R.id.profileStatus)
        val name = rowView.findViewById<TextView>(R.id.contactName)
        val duration = rowView.findViewById<TextView>(R.id.duration)
        val item = item[position]
        image.setImageResource(item.image)
        name.text = item.name
        duration.text = item.duration

        return rowView


    }


}