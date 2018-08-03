package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.kotlin.anative.nyanc0.nativekotlinsample.R
import com.example.kotlin.anative.nyanc0.nativekotlinsample.databinding.ActivityMainBinding
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.ToolbarUtil
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecipeListFragment
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecommendListFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ToolbarUtil.initToolbar(this, binding.toolbar, resources.getString(R.string.app_name), false)

        val adapter = MainPagerAdapter(supportFragmentManager)
        binding.pager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.pager)
    }

    inner class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        override fun getCount(): Int = 2

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> {
                    RecipeListFragment.newInstance()
                }
                1 -> {
                    RecommendListFragment.newInstance()
                }
                else -> {
                    RecipeListFragment.newInstance()
                }
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> {
                    "すべて"
                }
                1 -> {
                    "おすすめ"
                }
                else -> {
                    "すべて"
                }
            }
        }
    }
}