package com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.dao

import android.arch.persistence.room.*
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.entity.RecipeDbEntity
import io.reactivex.Flowable

@Dao
abstract class RecipeDao {
    @Query("SELECT * from recipe")
    abstract fun getAllRecipes(): Flowable<List<RecipeDbEntity>>

    @Query("DELETE from recipe")
    abstract fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(list: List<RecipeDbEntity>)

    @Transaction
    open fun clearAndInsert(list: List<RecipeDbEntity>) {
        deleteAll()
        insert(list)
    }
}