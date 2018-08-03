package sampleapp.practice.com.example.yuriyuri.sampleapp.presentation

import android.app.Application
import android.support.v7.app.AppCompatDelegate

/**
 * Application
 */
open class SampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}
