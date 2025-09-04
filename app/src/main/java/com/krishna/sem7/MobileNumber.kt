package com.krishna.sem7

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

data class MobileEntry(
    val serialNumber: String,
    val serialName: String,
    val serialPhoneNumber: String
)

class MobileNumber : AppCompatActivity() {
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var editTextName: EditText // Added for name input
    private lateinit var btnAddNumber: Button
    private lateinit var mobileNumberListView: ListView
    private lateinit var mobileListAdapter: MobileListAdapter
    private val mobileEntries = ArrayList<MobileEntry>()
    private var serialCounter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mobile_number)

        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber)
        editTextName = findViewById(R.id.editTextName) // Initialize editTextName
        btnAddNumber = findViewById(R.id.btnAddNumber)
        mobileNumberListView = findViewById(R.id.mobileNumberListView)

        mobileListAdapter = MobileListAdapter(this, mobileEntries)
        mobileNumberListView.adapter = mobileListAdapter

        btnAddNumber.setOnClickListener {
            val phoneNumber = editTextPhoneNumber.text.toString()
            val name = editTextName.text.toString() // Read name input

            if (phoneNumber.isNotBlank() && name.isNotBlank()) { // Ensure both fields are filled
                val newEntry = MobileEntry(
                    serialNumber = serialCounter.toString(),
                    serialName = name, // Use entered name
                    serialPhoneNumber = phoneNumber
                )
                mobileEntries.add(newEntry)
                mobileListAdapter.notifyDataSetChanged()
                editTextPhoneNumber.text.clear()
                editTextName.text.clear() // Clear name field
                serialCounter++
            }
        }
    }
}

class MobileListAdapter(context: Context, private val dataSource: ArrayList<MobileEntry>) :
    ArrayAdapter<MobileEntry>(context, R.layout.mobileview, dataSource) {

    private class ViewHolder {
        lateinit var serialNumberTextView: TextView
        lateinit var serialNameTextView: TextView
        lateinit var serialPhoneNumberTextView: TextView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.mobileview, parent, false)
            holder = ViewHolder()
            holder.serialNumberTextView = view.findViewById(R.id.serialNumber)
            holder.serialNameTextView = view.findViewById(R.id.serialName)
            holder.serialPhoneNumberTextView = view.findViewById(R.id.serialPhoneNumber)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val entry = getItem(position)
        if (entry != null) {
            holder.serialNumberTextView.text = entry.serialNumber
            holder.serialNameTextView.text = entry.serialName
            holder.serialPhoneNumberTextView.text = entry.serialPhoneNumber
        }

        return view
    }
}
