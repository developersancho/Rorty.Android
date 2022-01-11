/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.settings

import android.os.Bundle
import com.developersancho.framework.extensions.appVersion
import com.developersancho.rorty.base.BaseFragment
import com.developersancho.rorty.databinding.FragmentSettingsBinding
import com.developersancho.rorty.provider.AppProvider
import com.developersancho.rorty.provider.ThemeProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }

    @Inject
    lateinit var appProvider: AppProvider

    @Inject
    lateinit var themeProvider: ThemeProvider

    override fun onViewReady(bundle: Bundle?) {
        binding.tvAppVersion.text = context?.appVersion()
        binding.switchThemeMode.isChecked = appProvider.isNightMode
    }

    override fun onViewListener() {
        super.onViewListener()
        binding.switchThemeMode.setOnCheckedChangeListener { _, isChecked ->
            appProvider.isNightMode = isChecked
            themeProvider.setNightMode(forceNight = appProvider.isNightMode)
        }
    }
}