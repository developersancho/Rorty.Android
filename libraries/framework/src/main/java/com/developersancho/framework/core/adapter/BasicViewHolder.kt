/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.core.adapter

import androidx.viewbinding.ViewBinding
import com.developersancho.framework.core.base.binding.BindingViewHolder

/**
 * A Simple [BasicViewHolder] providing easier support for ViewBinding
 */
class BasicViewHolder<VB : ViewBinding>(binding: VB) : BindingViewHolder<VB>(binding)
