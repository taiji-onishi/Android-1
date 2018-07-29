package com.example.kotlin.anative.nyanc0.nativekotlinsample.data

import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.RecipeApi
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.response.toRecipe
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.Recipe
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.RecipeId
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.repository.RecipeRepository
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.SchedulerProvider
import io.reactivex.Single
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
        private val recipeApi: RecipeApi,
        private val schedulerProvider: SchedulerProvider
) : RecipeRepository {
    override fun getRecipe(recipeId: RecipeId): Single<Recipe> {
        return recipeApi.getRecipe(recipeId.value)
                .map { it ->
                    it.toRecipe()
                }.subscribeOn(schedulerProvider.io())
    }
}