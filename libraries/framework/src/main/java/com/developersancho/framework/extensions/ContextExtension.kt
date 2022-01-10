/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.extensions

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import timber.log.Timber

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

fun Context.drawable(@DrawableRes drawableRes: Int) =
    AppCompatResources.getDrawable(this@drawable, drawableRes)

fun Context.color(@ColorRes colorRes: Int) = ContextCompat.getColor(this@color, colorRes)