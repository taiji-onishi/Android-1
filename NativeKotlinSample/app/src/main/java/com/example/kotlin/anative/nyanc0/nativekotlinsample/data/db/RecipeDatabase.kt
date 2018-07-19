package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db

import android.arch.persistence.room.RoomDatabase
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.dao.RecipeDao
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.entity.RecipeDbEntity
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.response.RecipeRestEntity
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.response.toRecipeDbEntityList
import io.reactivex.Flowable
import javax.inject.Inject

class RecipeDatabase @Inject constructor(
        private val database: RoomDatabase,
        private val recipeDao: RecipeDao
) {
    fun getAllRecipeList(): Flowable<List<RecipeDbEntity>> = recipeDao.getAllRecipes()
    fun save(recipeList: List<RecipeRestEntity>) {
        database.runInTransaction {
            recipeDao.clearAndInsert(recipeList.toRecipeDbEntityList())
        }
    }
}