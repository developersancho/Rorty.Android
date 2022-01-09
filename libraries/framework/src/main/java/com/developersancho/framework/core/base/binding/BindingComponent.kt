/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.core.base.binding

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewbinding.ViewBinding
import com.developersancho.framework.extensions.inflater

open class BindingComponent<VB : ViewBinding> @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    lateinit var binding: VB

    init {
        initBinding()
    }

    private fun initBinding() {
        if (::binding.isInitialized.not()) {
            binding = getBinding(context.inflater, container = this)
        }
    }
}
