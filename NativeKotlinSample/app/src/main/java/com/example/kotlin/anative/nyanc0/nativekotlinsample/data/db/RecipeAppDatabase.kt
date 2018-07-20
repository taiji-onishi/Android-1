package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.dao.RecipeDao
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.entity.RecipeDbEntity

@Database(entities = [RecipeDbEntity::class], version = 1)
abstract class RecipeAppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}