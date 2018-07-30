package com.example.kotlin.anative.nyanc0.nativekotlinsample.di.activity

import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.DetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DetailActivityBuilder {
    @ContributesAndroidInjector(modules = [DetailActivityModule::class])
    fun contributeDetailActivity(): DetailActivity
}