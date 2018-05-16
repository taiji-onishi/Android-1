package sampleapp.practice.com.example.yuriyuri.sampleapp.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import sampleapp.practice.com.example.yuriyuri.sampleapp.di.module.ActivityModule
import sampleapp.practice.com.example.yuriyuri.sampleapp.di.module.AppModule
import sampleapp.practice.com.example.yuriyuri.sampleapp.di.module.NetworkModule
import sampleapp.practice.com.example.yuriyuri.sampleapp.di.module.ViewModelModule
import sampleapp.practice.com.example.yuriyuri.sampleapp.presentation.SampleApp
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityModule::class,
    NetworkModule::class,
    ViewModelModule::class])
interface AppComponent : AndroidInjector<SampleApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder

        fun build(): AppComponent

        fun viewModelModule(viewModelModule: ViewModelModule): Builder
    }

    override fun inject(instance: SampleApp)
}