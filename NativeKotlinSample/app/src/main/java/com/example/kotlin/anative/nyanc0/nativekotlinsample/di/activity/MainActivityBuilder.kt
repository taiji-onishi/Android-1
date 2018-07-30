package com.example.kotlin.anative.nyanc0.nativekotlinsample.di.activity

import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun contributeMainActivity(): MainActivity
}