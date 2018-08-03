package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view

import android.support.annotation.UiThread
import android.support.v7.widget.RecyclerView
import android.view.View

abstract class ArrayRecyclerAdapter<T, VH : RecyclerView.ViewHolder>
constructor(var list: ArrayList<T>) : RecyclerView.Adapter<VH>() {

    lateinit var listener: OnItemClickedListener<T>

    @UiThread
    fun reset(items: Collection<T>) {
        clear()
        addAll(items)
        notifyDataSetChanged()
    }

    fun clear() {
        list.clear()
    }

    fun addAll(items: Collection<T>) {
        list.addAll(items)
    }

    fun getItem(position: Int): T {
        return list[position]
    }

    fun addItem(item: T) {
        list.add(item)
    }

    fun addAll(position: Int, items: Collection<T>) {
        list.addAll(position, items)
    }

    @UiThread
    fun addAllWithNotify(items: Collection<T>) {
        val position = itemCount
        addAll(items)
        notifyItemInserted(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClickListener(listener: OnItemClickedListener<T>) {
        this.listener = listener
    }

    interface OnItemClickedListener<in T> {
        fun onItemClicked(view: View, data: T)
    }
}