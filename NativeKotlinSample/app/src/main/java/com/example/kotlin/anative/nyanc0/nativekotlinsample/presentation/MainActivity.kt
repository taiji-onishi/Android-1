package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.kotlin.anative.nyanc0.nativekotlinsample.R
import com.example.kotlin.anative.nyanc0.nativekotlinsample.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        val manager = supportFragmentManager
        var tagsFragment = manager.findFragmentByTag(RecipeListFragment.TAG)

        if (tagsFragment == null) {
            tagsFragment = RecipeListFragment.newInstance()
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, tagsFragment, RecipeListFragment.TAG)
        transaction.commit()
    }
}
