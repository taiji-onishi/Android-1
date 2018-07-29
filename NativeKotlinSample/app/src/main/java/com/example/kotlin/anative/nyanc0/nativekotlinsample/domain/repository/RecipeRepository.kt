package com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.repository

import android.support.annotation.CheckResult
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.Recipe
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.RecipeId
import io.reactivex.Single

interface RecipeRepository {
    @CheckResult
    fun getRecipe(recipeId: RecipeId): Single<Recipe>
}