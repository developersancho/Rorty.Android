/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.extensions

import android.content.res.Resources
import android.util.DisplayMetrics

val Int.dp: Float
    get() {
        if (this == 0) {
            return 0f
        }

        val metrics = Resources.getSystem().displayMetrics
        return this * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }