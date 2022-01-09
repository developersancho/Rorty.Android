/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.core.base.core

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.viewbinding.ViewBinding
import com.developersancho.framework.core.base.binding.BindingSheetDialog
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

abstract class CoreSheetDialog<VB : ViewBinding> : BindingSheetDialog<VB>() {
    protected var viewId: Int = -1

    lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    var bottomView: View? = null

    abstract fun onViewReady(bundle: Bundle?)

    open fun onViewListener() {}

    open fun observeUi() {}

    open fun onPreInit() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewId = binding.root.id
        observeUi()
        onViewReady(savedInstanceState)
        onViewListener()
    }

    fun setupFullHeight(bottomSheet: View?) {
        val layoutParams = bottomSheet?.layoutParams
        layoutParams?.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet?.layoutParams = layoutParams
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setOnShowListener {
            bottomView =
                dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomView?.let {
                bottomSheetBehavior = BottomSheetBehavior.from(it)
            }

            bottomSheetBehavior.peekHeight = Resources.getSystem().displayMetrics.heightPixels

            bottomSheetBehavior.addBottomSheetCallback(
                object : BottomSheetBehavior.BottomSheetCallback() {
                    override fun onStateChanged(view: View, newState: Int) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                            dismissAllowingStateLoss()
                        }
                        if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                        }
                    }

                    override fun onSlide(bottomSheet: View, slideOffset: Float) = Unit
                })
            onPreInit()
        }
        return dialog
    }
}
