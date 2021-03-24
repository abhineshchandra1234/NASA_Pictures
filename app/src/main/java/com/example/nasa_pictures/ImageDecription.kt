package com.example.nasa_pictures

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.nasa_pictures.ImageDetails.ImageDetails
import kotlinx.android.synthetic.main.fragment_image_description.*


class ImageDecription : Fragment(R.layout.fragment_image_description) {

    private val args by navArgs<ImageDecriptionArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        tvTitle.text = args.ImageDetails.title

    }

}