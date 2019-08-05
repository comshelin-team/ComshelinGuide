package com.comshelin.comshelinguide

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.restuarant_item.*
import java.io.ByteArrayOutputStream

class AddActivity : AppCompatActivity() {
    val GET_GALLERY_IMAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)

            intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
            startActivityForResult(intent, GET_GALLERY_IMAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode) {
            GET_GALLERY_IMAGE -> {
                if(data != null)
                    imageView.setImageURI(data?.data)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_add_action_bar, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                finish()
            }
            R.id.add -> {
                val intent = Intent()
                val iv: Bitmap = (imageView.drawable as BitmapDrawable).bitmap
                val bs = ByteArrayOutputStream();

                iv.compress(Bitmap.CompressFormat.JPEG, 50, bs)

                intent.putExtra("data", Restaurant(nameEditText.text.toString(), locationEditText.text.toString(), commentEditText.text.toString(), bs.toByteArray()))

                setResult(1, intent)

                finish()
            }
        }

        return true
    }
}
