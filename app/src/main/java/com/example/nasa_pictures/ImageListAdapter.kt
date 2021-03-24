package com.example.nasa_pictures

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nasa_pictures.ImageDetails.ImageDetails

class ImageListAdapter: RecyclerView.Adapter<ImageListAdapter.MyViewHolder>() {

    var imageList = mutableListOf<ImageDetails>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentImage = imageList[position]

    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}