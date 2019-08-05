package com.comshelin.comshelinguide

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val data = intent.getSerializableExtra("data") as Restaurant

        bigImageView.setImageBitmap(BitmapFactory.decodeByteArray(data.image, 0, data.image.size))
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> finish()
        }

        return true
    }
}
