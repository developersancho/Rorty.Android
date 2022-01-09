/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.extensions

import android.app.Activity
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.doOnLayout
import androidx.fragment.app.Fragment

private fun Activity.findFocusedView() = currentFocus ?: window.decorView

private fun Fragment.findFocusedView() = activity?.currentFocus ?: view

fun View.showSoftKeyboard() = doOnLayout {
    it.takeIf { it.requestFocus() }?.post {
        ViewCompat.getWindowInsetsController(it)?.show(WindowInsetsCompat.Type.ime())
    }
}

fun View.hideSoftKeyboard(clearFocus: Boolean = false) = doOnLayout {
    if (clearFocus) it.clearFocus()
    it.post {
        ViewCompat.getWindowInsetsController(it)?.hide(WindowInsetsCompat.Type.ime())
    }
}

fun Activity.showSoftKeyboard() = findFocusedView().showSoftKeyboard()

fun Fragment.showSoftKeyboard() = findFocusedView()?.showSoftKeyboard()

fun Activity.hideSoftKeyboard(clearFocus: Boolean = false) =
    findFocusedView().hideSoftKeyboard(clearFocus)

fun Fragment.hideSoftKeyboard(clearFocus: Boolean = false) =
    findFocusedView()?.hideSoftKeyboard(clearFocus)
