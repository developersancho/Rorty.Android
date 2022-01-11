/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.main

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.developersancho.framework.extensions.showSnackBar
import com.developersancho.framework.navigation.navigateFragment
import com.developersancho.rorty.R
import com.developersancho.rorty.base.BaseActivity
import com.developersancho.rorty.databinding.ActivityMainBinding
import com.developersancho.rorty.features.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private var backPressedOnce = false

    override fun onViewReady(bundle: Bundle?) {
        navigateFragment(HomeFragment.newInstance(), clearBackStack = true)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            super.onBackPressed()
        } else {
            if (backPressedOnce) {
                finish()
                return
            }
            backPressedOnce = true
            showSnackBar(
                binding.rootView,
                getString(R.string.app_exit_label),
                R.id.bottomNavView
            )
            lifecycleScope.launch {
                delay(2000)
                backPressedOnce = false
            }
        }
    }
}