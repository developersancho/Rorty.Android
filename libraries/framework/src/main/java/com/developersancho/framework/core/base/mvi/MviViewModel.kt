/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.core.base.mvi

import com.developersancho.framework.core.base.mvvm.MvvmViewModel
import com.developersancho.framework.core.flow.MutableEventFlow
import com.developersancho.framework.core.flow.asEventFlow

abstract class MviViewModel<STATE, EVENT> : MvvmViewModel() {

    private val _stateFlow = MutableEventFlow<STATE>()
    val stateFlow = _stateFlow.asEventFlow()

    abstract fun onTriggerEvent(eventType: EVENT)

    protected fun setState(state: STATE) = safeLaunch {
        _stateFlow.emit(state)
    }
}
