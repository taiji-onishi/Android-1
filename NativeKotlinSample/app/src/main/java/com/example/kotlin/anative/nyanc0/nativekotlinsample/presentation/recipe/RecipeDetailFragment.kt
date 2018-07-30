package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin.anative.nyanc0.nativekotlinsample.databinding.FragmentRecipeDetailBinding
import com.example.kotlin.anative.nyanc0.nativekotlinsample.databinding.ItemIngredientBinding
import com.example.kotlin.anative.nyanc0.nativekotlinsample.databinding.ItemMethodBinding
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.CookingIngredients
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.CookingMethod
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.RecipeId
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.Result
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view.Findable
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.ProgressTimeLatch
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RecipeDetailFragment : DaggerFragment(), Findable {

    private lateinit var binding: FragmentRecipeDetailBinding
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: RecipeDetailViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[RecipeDetailViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRecipeDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressTimeLatch = ProgressTimeLatch {
            binding.progress.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.isLoading.observe(this, Observer {
            progressTimeLatch.loading = it ?: false
        })

        viewModel.recipe.observe(this, Observer {
            when (it) {
                is Result.Success -> {
                    val recipe = it.data
                    binding.mainImage.load(recipe.imageUrl)
                    bindIngredient(recipe.ingredients)
                    bindMethod(recipe.cookingMethod)
                }
                is Result.Failure -> {
                    Log.d("TEST", it.errorMessage)
                }
            }
        })

        lifecycle.addObserver(viewModel)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val recipeId: RecipeId = arguments!!.getParcelable(KEY_RECIPE_ID)
        viewModel.loadRecipe(recipeId)
    }

    private fun bindIngredient(ingredientsList: List<CookingIngredients>) {
        for (cookingIngredients in ingredientsList) {
            val itemBinding: ItemIngredientBinding = ItemIngredientBinding.inflate(layoutInflater)
            itemBinding.ingredient = cookingIngredients
            binding.ingredientContainer.addView(itemBinding.root)
        }
    }

    private fun bindMethod(methodList: List<CookingMethod>) {
        for (method in methodList) {
            val itemBinding: ItemMethodBinding = ItemMethodBinding.inflate(layoutInflater)
            itemBinding.method = method
            binding.methodContainer.addView(itemBinding.root)
        }
    }

    companion object {
        val TAG = RecipeDetailFragment::class.java.canonicalName!!
        private const val KEY_RECIPE_ID = "key_recipe_id"

        fun newInstance(recipeId: RecipeId): RecipeDetailFragment {
            val fragment = RecipeDetailFragment()
            val bundle = Bundle()
            bundle.putParcelable(KEY_RECIPE_ID, recipeId)
            fragment.arguments = bundle
            return fragment
        }
    }

    override val tagForFinding: String
        get() = TAG
}