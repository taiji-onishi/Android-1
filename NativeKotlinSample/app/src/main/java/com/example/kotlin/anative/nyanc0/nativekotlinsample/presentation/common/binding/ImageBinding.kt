package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view.LoadingImageView


@BindingAdapter("loadImage")
fun setImageView(imageView: LoadingImageView, url: String?) {
    imageView.load(url)
}