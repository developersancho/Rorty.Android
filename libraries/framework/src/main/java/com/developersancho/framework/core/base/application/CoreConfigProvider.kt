/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.core.base.application

interface CoreConfigProvider<T : CoreConfig> {
    fun appConfig(): T
}
