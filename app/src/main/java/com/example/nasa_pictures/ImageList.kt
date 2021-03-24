package com.example.nasa_pictures

import android.content.Context
import android.os.Bundle
import android.os.ParcelFileDescriptor.open
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasa_pictures.ImageDetails.ImageDetails
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_image_list.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import kotlin.math.log


class ImageList : Fragment(R.layout.fragment_image_list) {

    var imageList = mutableListOf<ImageDetails>()
    private lateinit var adapter: ImageListAdapter
    private var gridLayoutManager: GridLayoutManager?= null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //Adapter
        adapter = ImageListAdapter()
        recyclerView.adapter = adapter
        //recyclerView.layoutManager = LinearLayoutManager(context)

        gridLayoutManager = GridLayoutManager(context,3, LinearLayoutManager.VERTICAL,false)
        recyclerView?.layoutManager = gridLayoutManager

        val fileInString: String =
            context?.assets?.open("data.json")?.bufferedReader().use { it?.readText().toString() }

        val jsonarray = JSONArray(fileInString)
        for (i in 0 until jsonarray.length()) {
            val jsonobject = jsonarray.getJSONObject(i)
            Log.d("Main", "date is ${jsonobject}")
            var url  = jsonobject.getString("url")
            var title  = jsonobject.getString("title")
            val imageInfo = ImageDetails("copyright","date","explanation","hdurl","media_type","service_version","title","url")
            imageList.add(imageInfo)
        }
        Log.d("Main", "Image list is $imageList")
        adapter.setData(imageList)



        Log.d("Main", "fragment json is $fileInString")
    }



}