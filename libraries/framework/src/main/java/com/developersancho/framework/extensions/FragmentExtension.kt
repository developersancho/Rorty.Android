/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


//companion object {
//    const val EXTRA_CHARACTER_PREVIEW = "extra_character_preview"
//    const val TAG = "CharacterDetailFragment"
//
//    fun newInstance(characterPreview: CharacterPreview): CharacterDetailFragment {
//        return CharacterDetailFragment().apply {
//            arguments = bundleOf(EXTRA_CHARACTER_PREVIEW to characterPreview)
//        }
//    }
//}
//
//private val characterPreview: CharacterPreview by argument(EXTRA_CHARACTER_PREVIEW)

@Suppress("unused")
inline fun <reified T : Any> Fragment.argument(key: String, default: T? = null): Lazy<T> {
    return lazy {
        val value = arguments?.get(key)
        requireNotNull(if (value is T) value else default) { key }
    }
}

//launchAndRepeatWithViewLifecycle {
//    launch {
//        viewModel.onViewState
//            .filterNotNull()
//            .collect(::bindViewState)
//    }
//}

/**
 * Launches a new coroutine and repeats `block` every time the Fragment's viewLifecycleOwner
 * is in and out of `minActiveState` lifecycle state.
 * @see https://github.com/google/iosched/blob/main/mobile/src/main/java/com/google/samples/apps/iosched/util/UiUtils.kt#L60
 */
@Suppress("unused")
inline fun Fragment.launchAndRepeatWithViewLifecycle(
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline block: suspend CoroutineScope.() -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.lifecycle.repeatOnLifecycle(minActiveState) {
            block()
        }
    }
}