/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.provider

import androidx.fragment.app.Fragment
import com.developersancho.rorty.features.characters.CharactersFragment
import com.developersancho.rorty.features.favorites.FavoritesFragment
import com.developersancho.rorty.features.settings.SettingsFragment

class HomeAdapterProviderImpl : HomeAdapterProvider {
    override fun createCharactersFragment(): Fragment {
        return CharactersFragment.newInstance()
    }

    override fun createFavoritesFragment(): Fragment {
        return FavoritesFragment.newInstance()
    }

    override fun createSettingsFragment(): Fragment {
        return SettingsFragment.newInstance()
    }
}