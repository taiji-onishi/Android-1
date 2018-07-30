package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

class ToolbarUtil {
    companion object {
        fun initToolbar(activity: AppCompatActivity, toolbar: Toolbar, title: String, isShow : Boolean) {
            activity.setSupportActionBar(toolbar)
            val bar = activity.supportActionBar
            bar!!.setDisplayHomeAsUpEnabled(isShow)
            bar.setDisplayShowHomeEnabled(isShow)
            bar.title = title
        }
    }
}