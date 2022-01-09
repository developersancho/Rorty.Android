/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.core.base.mvi

import androidx.viewbinding.ViewBinding
import com.developersancho.framework.core.base.mvvm.MvvmActivity
import com.developersancho.framework.extensions.observeFlowStart

abstract class MviActivity<VB : ViewBinding, STATE, VM : MviViewModel<STATE, *>> :
    MvvmActivity<VB, VM>() {

    abstract fun renderViewState(viewState: STATE)

    override fun observeUi() {
        super.observeUi()
        observeFlowStart(viewModel.stateFlow, ::renderViewState)
    }
}
