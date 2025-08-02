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

const val CAMPGROUND_EXTRA = "CAMPGROUND_EXTRA"

class CampgroundsAdapter(private val context: Context, private val campgrounds: List<Campground>) :
    RecyclerView.Adapter<CampgroundsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_campground, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(campgrounds[position])
    }

    override fun getItemCount() = campgrounds.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val campgroundImageView: ImageView = itemView.findViewById(R.id.itemCampgroundImage)
        private val campgroundNameTextView: TextView = itemView.findViewById(R.id.itemCampgroundTitle)
        private val campgroundDescriptionTextView: TextView = itemView.findViewById(R.id.itemCampgroundDescription)
        private val campgroundLatLongTextView: TextView = itemView.findViewById(R.id.itemCampgroundLatLong)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(campground: Campground) {
            campgroundNameTextView.text = campground.name
            campgroundDescriptionTextView.text = campground.description
            campgroundLatLongTextView.text = campground.latLong

            Glide.with(context)
                .load(campground.imageUrl)
                .into(campgroundImageView)
        }

        override fun onClick(v: View?) {
            val campground = campgrounds[absoluteAdapterPosition]
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(CAMPGROUND_EXTRA, campground)
            context.startActivity(intent)
        }
    }
}
