package com.example.kotlin.anative.nyanc0.nativekotlinsample.data

import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.RecipeApi
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.response.toRecipeList
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.Recipe
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.RecommendFlg
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.repository.RecommendListRepository
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.SchedulerProvider
import io.reactivex.Single
import javax.inject.Inject

class RecommendListRepositoryImpl @Inject constructor(
        private val recipeApi: RecipeApi,
        private val schedulerProvider: SchedulerProvider
) : RecommendListRepository {
    override fun getRecipe(): Single<List<Recipe>> {
        return recipeApi.getRecommendRecipeList(1)
                .map { it.toRecipeList() }
                .subscribeOn(schedulerProvider.io())
    }
}