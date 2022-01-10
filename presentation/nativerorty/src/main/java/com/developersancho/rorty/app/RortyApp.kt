/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.app

import com.developersancho.framework.core.base.application.AppInitializer
import com.developersancho.framework.core.base.application.CoreApplication
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

    override fun appConfig(): RortyAppConfig {
        return RortyAppConfig()
    }

    override fun onCreate() {
        super.onCreate()
        initializer.init(this)
    }
}