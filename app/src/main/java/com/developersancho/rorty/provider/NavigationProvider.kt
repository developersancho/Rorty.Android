/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.provider

import androidx.fragment.app.Fragment

interface NavigationProvider {
    fun launchMainActivity()
    fun launchDetailFragment(fragment: Fragment, detailId: Int)
}