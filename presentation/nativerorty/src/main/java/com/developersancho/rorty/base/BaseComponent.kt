/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.base

import android.content.Context
import android.util.AttributeSet
import androidx.viewbinding.ViewBinding
import com.developersancho.framework.core.base.core.CoreComponent

abstract class BaseComponent<VB : ViewBinding>(context: Context, attrs: AttributeSet? = null) :
    CoreComponent<VB>(context, attrs)