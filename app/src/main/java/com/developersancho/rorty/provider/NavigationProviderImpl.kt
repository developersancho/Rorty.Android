/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.provider

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.developersancho.framework.extensions.launchActivity
import com.developersancho.framework.navigation.AnimationType
import com.developersancho.framework.navigation.navigateFragment
import com.developersancho.rorty.features.detail.DetailFragment
import com.developersancho.rorty.features.main.MainActivity

class NavigationProviderImpl(private val context: Context) : NavigationProvider {
    override fun launchMainActivity() {
        context.launchActivity<MainActivity> {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
    }

    override fun launchDetailFragment(fragment: Fragment, detailId: Int) {
        val detailFragment = DetailFragment.newInstance(detailId = detailId)
        fragment.navigateFragment(fragment = detailFragment, animation = AnimationType.DEFAULT)
    }
}