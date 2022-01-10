package com.developersancho.framework.extensions

import android.app.Activity
import android.view.View
import android.view.ViewGroup

fun Activity.getRootView(): View =
    (this.findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0)
