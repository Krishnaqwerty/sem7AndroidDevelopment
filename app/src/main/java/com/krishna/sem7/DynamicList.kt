package com.krishna.sem7

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DynamicList<Bitmap> : AppCompatActivity() {

    lateinit var et1 : EditText
    lateinit var et2 : EditText
    lateinit var add : Button
    private lateinit var imageInput : ImageView
    private var selectedImageUri: Uri? = null

    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dynamic_list)

        var listView = findViewById<ListView>(R.id.listView2)
        var list = mutableListOf<Model2>()
        et1 = findViewById(R.id.inputTitle)
        et2 = findViewById(R.id.inputDes)
        add = findViewById(R.id.add)
        imageInput = findViewById(R.id.imageInput)
        val adapter = MyAdapterDyna(this, R.layout.listview, list)
        listView.adapter = adapter
        imageInput.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)

        }


        add.setOnClickListener {
            selectedImageUri?.let {
                list.add(Model2(et1.text.toString(),
                    et2.text.toString(), it))
                Toast.makeText(this, "Added",
                    Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
            } ?: run {
                Toast.makeText(this, "Please select an image first",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    @Deprecated("This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            selectedImageUri = data?.data
            selectedImageUri?.let {
                val bitmap: android.graphics.Bitmap? =
                    MediaStore.Images.Media.getBitmap(this.contentResolver, it)
                imageInput.setImageBitmap(bitmap)
            }


        }


        }
}

