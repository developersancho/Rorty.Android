/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.core.base.application

interface AppInitializer {
    fun init(application: CoreApplication<*>)
}