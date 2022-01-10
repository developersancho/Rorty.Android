/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.provider

import androidx.fragment.app.Fragment

interface HomeAdapterProvider {
    fun createCharactersFragment(): Fragment

    fun createFavoritesFragment(): Fragment

    fun createSettingsFragment(): Fragment
}