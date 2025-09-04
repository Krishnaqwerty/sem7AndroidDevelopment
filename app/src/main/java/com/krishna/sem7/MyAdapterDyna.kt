package com.krishna.sem7

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri

class MyAdapterDyna(private var mCtx : Context, private var resources : Int, private var items:MutableList<Model2>) :
    ArrayAdapter<Model2>(mCtx,resources,items)
{
    @SuppressLint("UseCompatLoadingForDrawables", "ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view : View = layoutInflater.inflate(resources,null)
        val imageView : ImageView = view.findViewById(R.id.myImage)
        val titleTextView : TextView = view.findViewById(R.id.textview1)
        val descriptionTextView : TextView = view.findViewById(R.id.textview2)
        val delete : TextView = view.findViewById(R.id.delete)

        val mItem : Model2 = items[position]

        imageView.setImageURI(mItem.image.toString().toUri())
        titleTextView.text = mItem.title
        descriptionTextView.text = mItem.description

        delete.setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
        }



        return view

    }
}