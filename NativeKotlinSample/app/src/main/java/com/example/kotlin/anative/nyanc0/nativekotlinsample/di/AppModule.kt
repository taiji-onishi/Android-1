package com.example.kotlin.anative.nyanc0.nativekotlinsample.di

import android.app.Application
import android.content.Context
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.RecipeListRepositoryImpl
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.db.RecipeDatabase
import com.example.kotlin.anative.nyanc0.nativekotlinsample.data.rest.RecipeApi
import com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.repository.RecipeListRepository
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.AppSchedulerProvider
import com.example.kotlin.anative.nyanc0.nativekotlinsample.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
internal object AppModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    @JvmStatic
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @Singleton
    @Provides
    @JvmStatic
    fun provideRecipeListRepository(api: RecipeApi, database: RecipeDatabase, schedulerProvider: SchedulerProvider): RecipeListRepository =
            RecipeListRepositoryImpl(api, database, schedulerProvider)

}