/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.app

import com.developersancho.framework.core.base.application.CoreApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RortyApp : CoreApplication<RortyAppConfig>() {
    override fun appConfig(): RortyAppConfig {
        return RortyAppConfig()
    }
}