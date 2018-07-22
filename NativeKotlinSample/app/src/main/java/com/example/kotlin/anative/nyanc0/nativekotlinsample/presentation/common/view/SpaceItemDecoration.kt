package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class SpaceItemDecoration(private val spaceSize: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent!!.getChildLayoutPosition(view) == 0) {
            outRect!!.top = spaceSize
            outRect.right = spaceSize
            outRect.left = spaceSize
        } else {
            outRect!!.top = spaceSize
            outRect.bottom = spaceSize
            outRect.right = spaceSize
            outRect.left = spaceSize
        }
    }
}