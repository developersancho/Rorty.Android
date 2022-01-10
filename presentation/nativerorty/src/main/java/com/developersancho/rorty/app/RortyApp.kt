/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.app

import com.developersancho.framework.core.base.application.AppInitializer
import com.developersancho.framework.core.base.application.CoreApplication
import com.developersancho.rorty.provider.AppProvider
import com.developersancho.rorty.provider.ThemeProvider
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * When using Hilt, the Application class must
 * be annotated with @HiltAndroidApp for kick
 * off the code generation.
 */
@HiltAndroidApp
class RortyApp : CoreApplication<RortyAppConfig>() {

    @Inject
    lateinit var initializer: AppInitializer

    @Inject
    lateinit var appProvider: AppProvider

    @Inject
    lateinit var themeProvider: ThemeProvider

    override fun appConfig(): RortyAppConfig {
        return RortyAppConfig()
    }

    override fun onCreate() {
        super.onCreate()
        initializer.init(this)
        initNightMode()
    }

    /**
     * Initialize Night Mode based on user last saved state (day/night themes).
     */
    private fun initNightMode() {
        appProvider.isNightMode = themeProvider.isDarkTheme(applicationContext)
        themeProvider.setNightMode(appProvider.isNightMode)
    }
}