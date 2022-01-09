/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.app

import com.developersancho.framework.core.base.application.CoreConfig
import com.developersancho.framework.core.base.application.CoreEnvironment
import com.developersancho.rorty.BuildConfig
import com.developersancho.rorty.features.main.MainActivity

class RortyAppConfig : CoreConfig() {
    override fun appName(): String {
        return "Rorty-Mobile"
    }

    override fun environment(): CoreEnvironment {
        return if (isDev()) {
            CoreEnvironment.DEV
        } else {
            CoreEnvironment.PROD
        }
    }

    override fun baseUrl(): String {
        return when (environment()) {
            CoreEnvironment.DEV, CoreEnvironment.TEST, CoreEnvironment.UAT -> {
                BuildConfig.BASE_URL
            }
            CoreEnvironment.PILOT, CoreEnvironment.PREP, CoreEnvironment.PROD -> {
                BuildConfig.BASE_URL
            }
        }
    }

    override fun timeOut(): Long {
        return 30L
    }

    override fun isDev(): Boolean {
        return BuildConfig.DEBUG
    }

    override fun enableSessionLogger(): Boolean {
        return isDev()
    }

    override fun enableNetworkLogger(): Boolean {
        return isDev()
    }

    override fun isSslPinningEnabled(): Boolean {
        return super.isSslPinningEnabled()
    }

    override fun uncaughtExceptionPage(): Class<*> {
        return MainActivity::class.java
    }

    override fun uncaughtExceptionMessage(): String {
        return "Unknown Error"
    }
}