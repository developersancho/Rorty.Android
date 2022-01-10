/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class SquareImageView(context: Context, attrs: AttributeSet) : AppCompatImageView(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}
