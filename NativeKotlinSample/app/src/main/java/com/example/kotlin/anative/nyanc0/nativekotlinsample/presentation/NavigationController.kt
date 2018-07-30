package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.kotlin.anative.nyanc0.nativekotlinsample.R
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.RecipeId
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view.Findable
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.DetailActivity
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecipeDetailFragment
import javax.inject.Inject

class NavigationController @Inject constructor(private val activity: AppCompatActivity) {

    private val containerId: Int = R.id.container
    private val fragmentManager: FragmentManager = activity.supportFragmentManager

    fun navigateToDetail(recipeId: RecipeId) {
        replaceFragment(RecipeDetailFragment.newInstance(recipeId))
    }

    fun navigateToDetailActivity(recipeId: RecipeId) {
        DetailActivity.startActivity(activity, recipeId)
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = fragmentManager
                .beginTransaction()
                .addToBackStack((fragment as? Findable)?.tagForFinding)
                .replace(containerId, fragment, (fragment as? Findable)?.tagForFinding)

        if (fragmentManager.isStateSaved) {
            transaction.commitAllowingStateLoss()
        } else {
            transaction.commit()
        }
    }

    fun backstackFragment() {
        Log.d("Stack count", fragmentManager.backStackEntryCount.toString() + "")
        if (fragmentManager.backStackEntryCount == 0) {
            activity.finish()
        }
    }
}