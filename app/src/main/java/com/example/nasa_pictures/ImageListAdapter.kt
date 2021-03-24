package com.example.nasa_pictures

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasa_pictures.ImageDetails.ImageDetails
import kotlinx.android.synthetic.main.recycler_item.view.*

class ImageListAdapter: RecyclerView.Adapter<ImageListAdapter.MyViewHolder>() {

    var imageList = emptyList<ImageDetails>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

        init {
            itemView.imageView.setOnClickListener {
                val position = adapterPosition

                val action = ImageListDirections.actionImageListToImageDetails(imageList[position])
                itemView.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentImage = imageList[position]

//        holder.itemView.imageView.setImageResource(R.mipmap.ic_launcher)

        Glide.with(holder.itemView.context).load("https://apod.nasa.gov/apod/image/1912/M94_Hubble_960.jpg").into(holder.itemView.imageView);
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    fun setData(image: List<ImageDetails>) {
        imageList  = image
        notifyDataSetChanged()
    }
}