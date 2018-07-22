package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation

import android.support.v7.app.AppCompatDelegate
import com.example.kotlin.anative.nyanc0.nativekotlinsample.di.DaggerAppComponent
import com.example.kotlin.anative.nyanc0.nativekotlinsample.di.DbModule
import com.example.kotlin.anative.nyanc0.nativekotlinsample.di.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

open class RecipeApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
                .application(this) // AppComponentのBuilderで設定
                .networkModule(NetworkModule.instance) // AppComponentのBuilderで設定
                .dbModule(DbModule.instance)
                .build()
    }
}