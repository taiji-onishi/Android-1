package com.example.kotlin.anative.nyanc0.nativekotlinsample.di.activity

import android.support.v7.app.AppCompatActivity
import com.example.kotlin.anative.nyanc0.nativekotlinsample.di.FragmentBuilderModule
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [(FragmentBuilderModule::class)])
    internal abstract fun contributeMainActivity(): MainActivity

    @Binds
    internal abstract fun providesAppCompatActivity(mainActivity: MainActivity): AppCompatActivity
}