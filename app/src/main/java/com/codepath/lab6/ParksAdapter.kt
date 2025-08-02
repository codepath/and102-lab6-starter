package com.codepath.lab6

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val PARK_EXTRA = "PARK_EXTRA"

class ParksAdapter(private val context: Context, private val parks: List<Park>) :
    RecyclerView.Adapter<ParksAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_park, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(parks[position])
    }

    override fun getItemCount() = parks.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val parkImageView: ImageView = itemView.findViewById(R.id.itemParkImage)
        private val parkNameTextView: TextView = itemView.findViewById(R.id.itemParkTitle)
        private val parkDescriptionTextView: TextView = itemView.findViewById(R.id.itemParkDescription)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(park: Park) {
            parkNameTextView.text = park.fullName
            parkDescriptionTextView.text = park.description
            Glide.with(context).load(park.imageUrl).into(parkImageView)
        }

        override fun onClick(v: View?) {
            val park = parks[absoluteAdapterPosition]
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(PARK_EXTRA, park)
            context.startActivity(intent)
        }
    }
}
