/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.characters

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.core.animation.doOnEnd
import androidx.core.content.ContextCompat
import coil.load
import com.developersancho.model.remote.base.Status
import com.developersancho.rorty.R

fun ImageView.setStatus(status: Status?) {
    val statusDrawable = when (status) {
        Status.Alive -> R.drawable.ic_status_circle_green
        Status.Dead -> R.drawable.ic_status_circle_red
        Status.Unknown -> R.drawable.ic_status_circle_gray
        else -> R.drawable.ic_status_circle_gray
    }
    this.load(statusDrawable)
}

fun TextView.setStatus(status: Status?) {
    text = status?.name
}

fun ImageView.startAnimation(state: Boolean, onDoEnd: () -> Unit) {
    val rotationAnim = if (state) {
        ObjectAnimator.ofFloat(this, "rotation", 0f, 360f)
    } else {
        ObjectAnimator.ofFloat(this, "rotation", 360f, 0f)
    }.apply {
        duration = 300
        interpolator = AccelerateInterpolator()
    }

    val bounceAnimX = ObjectAnimator.ofFloat(this, "scaleX", 0.2f, 1f).apply {
        duration = 300
        interpolator = OvershootInterpolator()
    }

    val bounceAnimY = ObjectAnimator.ofFloat(this, "scaleY", 0.2f, 1f).apply {
        duration = 300
        interpolator = OvershootInterpolator()
    }

    val colorAnim = if (state) {
        ObjectAnimator.ofArgb(
            this, "colorFilter",
            ContextCompat.getColor(this.context, R.color.grey_700),
            ContextCompat.getColor(this.context, R.color.red_700)
        )
    } else {
        ObjectAnimator.ofArgb(
            this, "colorFilter",
            ContextCompat.getColor(this.context, R.color.red_700),
            ContextCompat.getColor(this.context, R.color.grey_700)
        )
    }.apply {
        duration = 600
        interpolator = AccelerateDecelerateInterpolator()
    }

    AnimatorSet().apply {
        play(rotationAnim).with(colorAnim)
        play(bounceAnimX).with(bounceAnimY).after(rotationAnim)
        doOnEnd {
            onDoEnd.invoke()
        }
        start()
    }
}
