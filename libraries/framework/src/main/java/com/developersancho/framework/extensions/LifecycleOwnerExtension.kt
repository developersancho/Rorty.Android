/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.extensions

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun <T> LifecycleOwner.observeFlow(property: Flow<T>, block: (T) -> Unit) {
    lifecycleScope.launch {
        property.collect { block(it) }
    }
}

fun <T> LifecycleOwner.observeFlowStart(property: Flow<T>, block: (T) -> Unit) {
    lifecycleScope.launch {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            property.collect { block(it) }
        }
    }
}

fun <T> LifecycleOwner.observeLiveData(liveData: LiveData<T>, block: (T) -> Unit) {
    liveData.observe(this, Observer { block(it) })
}

fun <T : Any, L : MutableLiveData<T>> LifecycleOwner.observeLiveData(
    liveData: L,
    block: (T) -> Unit
) {
    liveData.observe(this, Observer { block(it) })
}

fun LifecycleOwner.repeatOnStared(block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED, block)
    }
}
