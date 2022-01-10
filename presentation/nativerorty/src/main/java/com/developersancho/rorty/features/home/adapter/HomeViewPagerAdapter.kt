/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.developersancho.rorty.features.home.adapter.HomePage.Companion.toHomePageFromPosition
import com.developersancho.rorty.provider.HomeAdapterProvider

class HomeViewPagerAdapter(
    fragment: Fragment,
    private val homeAdapterProvider: HomeAdapterProvider
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return HomePage.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position.toHomePageFromPosition()) {
            HomePage.CHARACTERS -> homeAdapterProvider.createCharactersFragment()
            HomePage.FAVORITES -> homeAdapterProvider.createFavoritesFragment()
            HomePage.SETTINGS -> homeAdapterProvider.createSettingsFragment()
        }
    }
}
