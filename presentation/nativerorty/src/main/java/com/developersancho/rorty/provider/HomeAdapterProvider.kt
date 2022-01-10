package com.developersancho.rorty.provider

import androidx.fragment.app.Fragment

interface HomeAdapterProvider {
    fun createCharactersFragment(): Fragment

    fun createFavoritesFragment(): Fragment

    fun createSettingsFragment(): Fragment
}