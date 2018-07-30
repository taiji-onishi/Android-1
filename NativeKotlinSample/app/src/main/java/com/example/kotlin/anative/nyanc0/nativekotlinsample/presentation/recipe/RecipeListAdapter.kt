package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe

import android.view.ViewGroup
import com.example.kotlin.anative.nyanc0.nativekotlinsample.R
import com.example.kotlin.anative.nyanc0.nativekotlinsample.databinding.ItemRecipeBinding
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.Recipe
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.binding.BindingHolder
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view.ArrayRecyclerAdapter

class RecipeListAdapter(list: ArrayList<Recipe>)
    : ArrayRecyclerAdapter<Recipe, BindingHolder<ItemRecipeBinding>>(list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<ItemRecipeBinding> {
        return BindingHolder(parent.context, parent, R.layout.item_recipe)
    }

    override fun onBindViewHolder(holder: BindingHolder<ItemRecipeBinding>, position: Int) {
        val data = list[position]
        holder.binding!!.recipe = data
        holder.binding.root.setOnClickListener({ listener.onItemClicked(it, data) })
    }
}