/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.developersancho.components.DialogHelper
import com.developersancho.framework.extensions.isInternetAvailable
import com.developersancho.rorty.R
import com.developersancho.rorty.provider.NavigationProvider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var navigationProvider: NavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenCreated {
            if (isInternetAvailable()) {
                delay(3000)
                openMainActivity()
            } else {
                DialogHelper.showInternetCheckDialog(this@SplashActivity) {
                    finishAndRemoveTask()
                }
            }
        }
    }

    private fun openMainActivity() {
        navigationProvider.launchMainActivity()
        overridePendingTransition(
            R.anim.fade_in,
            R.anim.splash_fade_out
        )
    }
}