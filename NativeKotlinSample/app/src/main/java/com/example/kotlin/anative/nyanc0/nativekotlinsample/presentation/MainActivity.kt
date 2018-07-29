package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.kotlin.anative.nyanc0.nativekotlinsample.R
import com.example.kotlin.anative.nyanc0.nativekotlinsample.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var navigationController: NavigationController

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        navigationController.backstackFragment()
    }

    private fun initFragment() {
        navigationController.navigateToRecipeList()
    }
}
