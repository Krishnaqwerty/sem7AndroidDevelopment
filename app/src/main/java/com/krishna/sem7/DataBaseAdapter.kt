package com.krishna.sem7

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class DataBaseAdapter(private val context: Context, private val arrayList: java.util.ArrayList<MyMobileNumber>) : BaseAdapter() {


    private  lateinit var serialNumber: TextView

    private  lateinit var name: TextView

    private  lateinit var phoneNumber: TextView

    override fun getCount(): Int {

        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        convertView = View.inflate(context, R.layout.mobileview, null)
        serialNumber = convertView.findViewById(R.id.serialNumber)
        name = convertView.findViewById(R.id.serialName)
        phoneNumber = convertView.findViewById(R.id.serialPhoneNumber)
        serialNumber.text = arrayList[position].serialNumber.toString()
        name.text = arrayList[position].name
        phoneNumber.text = arrayList[position].phoneNumber
        return convertView

    }

}