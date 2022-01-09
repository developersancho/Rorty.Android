/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.core.base.application

abstract class CoreConfig {
    abstract fun appName(): String

    abstract fun environment(): CoreEnvironment

    abstract fun baseUrl(): String

    abstract fun timeOut(): Long

    open fun isDev() = false

    open fun enableSessionLogger() = false

    open fun enableNetworkLogger() = false

    open fun isSslPinningEnabled() = true

    open fun uncaughtExceptionPage(): Class<*>? = null

    open fun uncaughtExceptionMessage(): String? = null
}
