package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin.anative.nyanc0.nativekotlinsample.databinding.FragmentRecipeListBinding
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.Recipe
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.NavigationController
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.Result
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view.ArrayRecyclerAdapter
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view.Findable
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view.SpaceItemDecoration
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.ProgressTimeLatch
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RecipeListFragment : DaggerFragment(), Findable {

    private lateinit var binding: FragmentRecipeListBinding
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var navigationController: NavigationController
    private lateinit var adapter: RecipeListAdapter
    private val viewModel: RecipeListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[RecipeListViewModel::class.java]
    }

    companion object {
        fun newInstance(): RecipeListFragment = RecipeListFragment()
        val TAG = RecipeListFragment::class.java.canonicalName!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecipeListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUpRecyclerView()

        val progressTimeLatch = ProgressTimeLatch {
            binding.progress.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.recipeList.observe(this, Observer { result ->
            when (result) {
                is Result.Success -> {
                    renderView(result.data)
                }
                is Result.Failure -> {
                    // TODO:エラーハンドリング
                }
            }
        })

        viewModel.isLoading.observe(this, Observer {
            progressTimeLatch.loading = it ?: false
        })

        viewModel.refreshResult.observe(this, Observer { result ->
            when (result) {
                is Result.Failure -> {
                    // TODO:エラーハンドリング
                }
            }
        })

        lifecycle.addObserver(viewModel)
    }

    override val tagForFinding: String
        get() = TAG

    private fun setUpRecyclerView() {
        binding.recyclerView.addItemDecoration(SpaceItemDecoration(8))
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
    }

    private fun renderView(list: List<Recipe>) {
        if (binding.recyclerView.adapter == null) {
            adapter = RecipeListAdapter((ArrayList(list)))
            adapter.setOnItemClickListener(object : ArrayRecyclerAdapter.OnItemClickedListener<Recipe> {
                override fun onItemClicked(view: View, data: Recipe) {
                    navigationController.navigateToDetailActivity(data.recipeId, data.recipeName)
                }
            })
            binding.recyclerView.adapter = adapter
        } else {
            adapter.reset(list)
        }
    }
}