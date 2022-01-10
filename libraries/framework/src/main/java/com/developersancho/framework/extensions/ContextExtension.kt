/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.extensions

import android.content.Context
import android.content.res.Configuration

val Context.isDarkMode: Boolean?
    get() {
        return when (resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> true
            Configuration.UI_MODE_NIGHT_NO -> false
            Configuration.UI_MODE_NIGHT_UNDEFINED -> null
            else -> null
        }
    }

fun Context.dp2px(value: Int): Int {
    val scale = resources.displayMetrics.density
    return (value.toFloat() * scale + 0.5f).toInt()
}