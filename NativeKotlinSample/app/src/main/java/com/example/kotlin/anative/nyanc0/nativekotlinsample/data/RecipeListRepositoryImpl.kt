package com.example.kotlin.anative.nyanc0.nativekotlinsample.data

import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.RecipeDatabase
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.entity.toRecipeList
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.RecipeApi
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model.Recipe
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.repository.RecipeListRepository
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class RecipeListRepositoryImpl @Inject constructor(
        private val recipeApi: RecipeApi,
        private val recipeDatabase: RecipeDatabase,
        private val schedulerProvider: SchedulerProvider
) : RecipeListRepository {

    override val recipeList: Flowable<List<Recipe>>
        get() = recipeDatabase.getAllRecipeList().map {
            it.toRecipeList()
        }.subscribeOn(schedulerProvider.io())

    override fun getRecipeList(): Completable {
        return recipeApi.getRecipeList()
                .doOnSuccess {
                    recipeDatabase.save(it)
                }
                .subscribeOn(schedulerProvider.io())
                .toCompletable()
    }
}