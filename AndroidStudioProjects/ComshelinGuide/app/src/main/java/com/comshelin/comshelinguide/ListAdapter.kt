package com.comshelin.comshelinguide

import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.restuarant_item.view.*

class ListAdapter(private val restaurantData: List<Restaurant>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.restuarant_item, p0, false)

        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return restaurantData.size
    }

    override fun onBindViewHolder(p0: ListViewHolder, p1: Int) {
        p0.nameTextView.text = restaurantData[p1].name
        p0.locationTextView.text = restaurantData[p1].location
        p0.openTextView.text = restaurantData[p1].comment
        p0.restaurantImageView.setImageBitmap(BitmapFactory.decodeByteArray(restaurantData[p1].image, 0, restaurantData[p1].image.size))

        p0.itemView.cardView.setOnClickListener {
            val intent = (Intent(p0.itemView.context, InfoActivity::class.java))

            intent.putExtra("data", restaurantData[p1])

            p0.itemView.context.startActivity(intent)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val restaurantImageView: ImageView = itemView.findViewById(R.id.restaurantImageView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)
        val openTextView: TextView = itemView.findViewById(R.id.openTextView)

    }
}