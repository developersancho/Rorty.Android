/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.provider

import android.content.Context
import com.developersancho.framework.core.pref.CacheManager

class AppProviderImpl constructor(context: Context) : AppProvider {

    companion object {
        private const val PREF_PACKAGE_NAME = "com.developersancho.rorty.provider"
        private const val PREF_KEY_NIGHT_MODE = "night_mode"
    }

    private val cacheManager = CacheManager(context, PREF_PACKAGE_NAME)

    override var isNightMode: Boolean
        get() = cacheManager.read(PREF_KEY_NIGHT_MODE, false)
        set(isDarkMode) = cacheManager.write(PREF_KEY_NIGHT_MODE, isDarkMode)
}