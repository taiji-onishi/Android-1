package com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.repository

import android.support.annotation.CheckResult
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.Recipe
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Interface that represents a Repository for getting {@link Recipe} related data.
 */
interface RecipeListRepository {

    val recipeList: Flowable<List<Recipe>>

    @CheckResult
    fun getRecipeList(): Completable
}