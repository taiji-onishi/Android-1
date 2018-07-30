package com.example.kotlin.anative.nyanc0.nativekotlinsample.di

import android.app.Application
import com.example.kotlin.anative.nyanc0.nativekotlinsample.di.activity.DetailActivityBuilder
import com.example.kotlin.anative.nyanc0.nativekotlinsample.di.activity.MainActivityBuilder
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.RecipeApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    DbModule::class,
    ViewModelModule::class,
    MainActivityBuilder::class,
    DetailActivityBuilder::class])
interface AppComponent : AndroidInjector<RecipeApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder

        fun dbModule(dbModule: DbModule): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: RecipeApplication)
}