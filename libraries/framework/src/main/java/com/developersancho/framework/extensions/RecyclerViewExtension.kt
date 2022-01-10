/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.extensions

import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView

var RecyclerView.isScrollable: Boolean
    set(value) {
        ViewCompat.setNestedScrollingEnabled(this, value)
    }
    get() = ViewCompat.isNestedScrollingEnabled(this)