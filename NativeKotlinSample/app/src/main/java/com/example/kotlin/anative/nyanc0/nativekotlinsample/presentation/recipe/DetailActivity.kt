package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.MenuItem
import com.example.kotlin.anative.nyanc0.nativekotlinsample.R
import com.example.kotlin.anative.nyanc0.nativekotlinsample.databinding.ActivityDetailBinding
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.RecipeId
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.NavigationController
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.ToolbarUtil
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var navigationController: NavigationController
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        ToolbarUtil.initToolbar(this, binding.toolbar, intent.getStringExtra(KEY_RECIPE_NAME), true)
        initFragment()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        navigationController.backstackFragment()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initFragment() {
        val recipeId: RecipeId = intent.getBundleExtra(KEY_INTENT).getParcelable(KEY_RECIPE_ID)
        navigationController.navigateToDetail(recipeId)
    }

    companion object {
        private const val KEY_RECIPE_ID = "key_recipe_id"
        private const val KEY_RECIPE_NAME = "key_recipe_name"
        private const val KEY_INTENT = "key_intent"

        fun startActivity(context: Context, recipeId: RecipeId, recipeName: String) {
            val intent = Intent(context, DetailActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelable(KEY_RECIPE_ID, recipeId)
            intent.putExtra(KEY_RECIPE_NAME, recipeName)
            intent.putExtra(KEY_INTENT, bundle)
            context.startActivity(intent)
        }
    }
}