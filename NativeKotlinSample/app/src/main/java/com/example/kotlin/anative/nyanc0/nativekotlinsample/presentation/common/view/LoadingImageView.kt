package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view

import android.content.Context
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.DrawableRequestBuilder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.kotlin.anative.nyanc0.nativekotlinsample.R
import java.lang.Exception


class LoadingImageView : FrameLayout {

    private val imageView: ImageView
    private var progressBar: ProgressBar = ProgressBar(context)
    private var sizeW = 0
    private var sizeH = 0

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        imageView = createImageView(context, attrs)
        init()
    }

    private fun createImageView(context: Context, attrs: AttributeSet?): ImageView = ImageView(context, attrs)
    private fun init() {
        imageView.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        imageView.adjustViewBounds = true
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        progressBar = ProgressBar(context)
        progressBar.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER)
        hideProgress()
        addView(imageView)
        addView(progressBar)
    }

    fun setResize(sizeW: Int, sizeH: Int) {
        this.sizeW = sizeW
        this.sizeH = sizeH
    }

    private fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    private fun showNoImage() {
        imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_no_image))
    }

    fun load(@Nullable url: String?) {
        if (TextUtils.isEmpty(url)) {
            showNoImage()
        } else {
            loadImage(url)
        }
    }

    private fun loadImage(@NonNull url: String?) {
        showProgress()
        val builder: DrawableRequestBuilder<String> = if (sizeH != 0 || sizeW != 0) {

            Glide.with(imageView.context)
                    .load(url)
                    .override(sizeH, sizeW)
        } else {
            Glide.with(imageView.context)
                    .load(url)
        }

        builder.listener(object : RequestListener<String, GlideDrawable> {
            override fun onException(e: Exception?, model: String?, target: Target<GlideDrawable>?, isFirstResource: Boolean): Boolean {
                hideProgress()
                showNoImage()
                return false
            }

            override fun onResourceReady(resource: GlideDrawable?, model: String?, target: Target<GlideDrawable>?, isFromMemoryCache: Boolean, isFirstResource: Boolean): Boolean {
                hideProgress()
                return false
            }
        }).fitCenter().into(imageView)
    }

}