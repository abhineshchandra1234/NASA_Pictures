package com.example.nasa_pictures

import android.content.Context
import android.os.Bundle
import android.os.ParcelFileDescriptor.open
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException


class ImageList : Fragment(R.layout.fragment_image_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val fileInString: String =
            context?.assets?.open("data.json")?.bufferedReader().use { it?.readText().toString() }

        val jsonarray = JSONArray(fileInString)
        for (i in 0 until jsonarray.length()) {
            val jsonobject = jsonarray.getJSONObject(i)
            Log.d("Main", "date is ${jsonobject}")
        }



        Log.d("Main", "fragment json is $fileInString")
    }



}