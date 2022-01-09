/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.base.mvi

import androidx.viewbinding.ViewBinding
import com.developersancho.components.ProgressDialog
import com.developersancho.framework.core.base.mvi.MviFragment
import com.developersancho.framework.core.base.mvi.MviViewModel
import com.developersancho.framework.extensions.showSnackBar
import timber.log.Timber

abstract class BaseMviFragment<VB : ViewBinding, STATE, VM : MviViewModel<STATE, *>> :
    MviFragment<VB, STATE, VM>() {

    private var progressDialog: ProgressDialog? = null

    override fun showProgress() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(requireContext())
        }
        progressDialog?.show()
    }

    override fun hideProgress() {
        progressDialog?.dismiss()
    }

    override fun showError(throwable: Throwable) {
        handleErrorMessage(throwable.message.toString())
    }

    protected open fun handleErrorMessage(message: String?) {
        if (message.isNullOrBlank()) return
        hideProgress()
        Timber.e(message)
        showSnackBar(binding.root, message)
    }
}