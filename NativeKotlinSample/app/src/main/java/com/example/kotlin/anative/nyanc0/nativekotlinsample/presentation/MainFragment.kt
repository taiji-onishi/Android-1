package com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin.anative.nyanc0.nativekotlinsample.databinding.FragmentMainBinding
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.common.view.Findable
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecipeListFragment
import com.example.kotlin.anative.nyanc0.nativekotlinsample.presentation.recipe.RecommendListFragment
import dagger.android.support.DaggerFragment


class MainFragment : DaggerFragment(), Findable {

    private lateinit var binding: FragmentMainBinding

    companion object {
        val TAG = MainFragment::class.java.canonicalName!!
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MainPagerAdapter(activity!!.supportFragmentManager)
        binding.pager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.pager)
    }

    override val tagForFinding: String
        get() = TAG

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