package com.krishna.sem7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class GridAdapter(private val context: Context, private val items: List<GridItemData>) : BaseAdapter() {

    private val inflater = LayoutInflater.from(context)

    override fun getCount(): Int {

        return items.size

    }

    override fun getItem(position: Int): Any? {

        return items[position]

    }

    override fun getItemId(position: Int): Long {

        return position.toLong()

    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val rowView = convertView ?: inflater.inflate(R.layout.griditem, parent, false)


        val image = rowView.findViewById<ImageView>(R.id.itemImage)
        val text = rowView.findViewById<TextView>(R.id.imageText)
        val item = items[position]
        image.setImageResource(item.image)
        text.text = item.imageText

        return rowView
    }


}