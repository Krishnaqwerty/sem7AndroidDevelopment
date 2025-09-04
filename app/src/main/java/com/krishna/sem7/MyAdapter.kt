package com.krishna.sem7

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private var mCtx : Context, private var resources : Int, private var item:List<Model>) :
    ArrayAdapter<Model>(mCtx,resources,item)
{
    @SuppressLint("UseCompatLoadingForDrawables", "ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view : View = layoutInflater.inflate(resources,null)
        val imageView : ImageView = view.findViewById(R.id.myImage)
        val titleTextView : TextView = view.findViewById(R.id.textview1)
        val descriptionTextView : TextView = view.findViewById(R.id.textview2)

        val mItem : Model = item[position]

        imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.image))
        titleTextView.text = mItem.title
        descriptionTextView.text = mItem.description
        return view

    }
}