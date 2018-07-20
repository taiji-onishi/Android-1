package com.example.kotlin.anative.nyanc0.nativekotlinsample.di

import android.app.Application
import android.arch.persistence.room.Room
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.RecipeAppDatabase
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.RecipeDatabase
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.dao.RecipeDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class DbModule {

    companion object {
        val instance = DbModule()
    }

    @Singleton
    @Provides
    open fun provideRecipeAppDatabase(app: Application): RecipeAppDatabase = Room.databaseBuilder(app, RecipeAppDatabase::class.java, "recipesample.db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideRecipeDatabase(database: RecipeAppDatabase, dao: RecipeDao) = RecipeDatabase(database, dao)

    @Singleton
    @Provides
    fun provideRecipeDao(database: RecipeAppDatabase) = database.recipeDao()
}