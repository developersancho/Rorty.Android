/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.content.res.AppCompatResources
import com.google.android.material.switchmaterial.SwitchMaterial

class ThemeSwitch @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : SwitchMaterial(context, attrs) {

    init {
        thumbDrawable = AppCompatResources.getDrawable(context, R.drawable.selector_dark_light)
        trackDrawable = AppCompatResources.getDrawable(context, R.drawable.selector_bg_dark_light)
    }
}
