/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.extensions

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.developersancho.framework.extensions.helper.DividerItemDecorator
import com.google.android.material.appbar.AppBarLayout

var RecyclerView.isScrollable: Boolean
    set(value) {
        ViewCompat.setNestedScrollingEnabled(this, value)
    }
    get() = ViewCompat.isNestedScrollingEnabled(this)

fun RecyclerView.getOrientation(): Int? {
    return if (layoutManager is LinearLayoutManager) {
        val layoutManager = layoutManager as LinearLayoutManager
        layoutManager.orientation.orZero()
    } else {
        null
    }
}

fun RecyclerView.addDividerDrawable(dividerDrawable: Drawable) {
    getOrientation()?.let { orientation ->
        val dividerItemDecoration = DividerItemDecorator(dividerDrawable, orientation)
        addItemDecoration(dividerItemDecoration)
    }
}

fun RecyclerView.setItemDecoration(left: Int, top: Int, right: Int, bottom: Int) {
    addItemDecoration(object : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.left = context.dp2px(left)
            outRect.top = context.dp2px(top)
            outRect.right = context.dp2px(right)
            outRect.bottom = context.dp2px(bottom)
        }
    })
}

fun RecyclerView.setAppBarElevationListener(appBar: AppBarLayout?) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            appBar?.let {
                if (canScrollVertically(-1)) ViewCompat.setElevation(it, 6f)
                else ViewCompat.setElevation(it, 0f)
            }
        }
    })
}

fun RecyclerView.setSnapHelper() {
    val snapHelper = LinearSnapHelper()
    snapHelper.attachToRecyclerView(this)
}

fun RecyclerView.setDefaultLayoutManager() {
    if (layoutManager != null) return
    layoutManager = LinearLayoutManager(context)
}