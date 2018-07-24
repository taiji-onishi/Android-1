package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin.anative.nyanc0.nativekotlinsample.R
import com.example.kotlin.anative.nyanc0.nativekotlinsample.databinding.FragmentRecipeListBinding
import com.example.kotlin.anative.nyanc0.nativekotlinsample.databinding.ItemRecipeBinding
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.Recipe
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.binding.BindingHolder
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view.ArrayRecyclerAdapter
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view.SpaceItemDecoration
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.ProgressTimeLatch
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RecipeListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: RecipeListViewModel
    private lateinit var recipeListViewBinding: FragmentRecipeListBinding
    private lateinit var adapter: RecipeListAdapter

    companion object {
        fun newInstance(): RecipeListFragment = RecipeListFragment()
        val TAG = RecipeListFragment::class.java.canonicalName
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        recipeListViewBinding = FragmentRecipeListBinding.inflate(layoutInflater, container, false)
        return recipeListViewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecyclerView()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RecipeListViewModel::class.java)

        val progressTimeLatch = ProgressTimeLatch {
            recipeListViewBinding.progress.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.recipeList.observe(this, Observer { result ->
            when (result) {
                is Result.Success -> {
                    renderView(result.data)
                }
                is Result.Failure -> {
                    Log.d("NWError", result.errorMessage)
                    // TODO:エラーハンドリング
                }
            }
        })

        viewModel.isLoading.observe(this, Observer {
            progressTimeLatch.loading = it ?: false
        })

        viewModel.reloadResult.observe(this, Observer { result ->
            when (result) {
                is Result.Failure -> {
                    // TODO:エラーハンドリング
                    Log.d("NWError", result.errorMessage)
                }
            }
        })

        lifecycle.addObserver(viewModel)
    }

    private fun setUpRecyclerView() {
        recipeListViewBinding.recyclerView.addItemDecoration(SpaceItemDecoration(8))
        recipeListViewBinding.recyclerView.layoutManager = LinearLayoutManager(this.context)
    }

    private fun renderView(list: List<Recipe>) {
        if (recipeListViewBinding.recyclerView.adapter == null) {
            adapter = RecipeListAdapter((ArrayList(list)))
            recipeListViewBinding.recyclerView.adapter = adapter
        } else {
            adapter.reset(list)
        }
    }

    inner class RecipeListAdapter(list: ArrayList<Recipe>)
        : ArrayRecyclerAdapter<Recipe, BindingHolder<ItemRecipeBinding>>(list) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<ItemRecipeBinding> {
            return BindingHolder(parent.context, parent, R.layout.item_recipe)
        }

        override fun onBindViewHolder(holder: BindingHolder<ItemRecipeBinding>, position: Int) {
            val data = list[position]
            holder.binding!!.recipe = data
        }
    }
}