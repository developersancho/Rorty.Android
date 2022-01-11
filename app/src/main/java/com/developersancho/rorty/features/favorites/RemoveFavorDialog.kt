/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.favorites

import android.os.Bundle
import androidx.core.os.bundleOf
import com.developersancho.framework.extensions.argument
import com.developersancho.framework.extensions.orZero
import com.developersancho.framework.extensions.setSafeOnClickListener
import com.developersancho.model.dto.CharacterDto
import com.developersancho.rorty.R
import com.developersancho.rorty.base.BaseSheetDialog
import com.developersancho.rorty.databinding.DialogRemoveFavorBinding

class RemoveFavorDialog : BaseSheetDialog<DialogRemoveFavorBinding>() {

    companion object {
        private const val ARG_FAVOR = "arg_favor"

        @JvmStatic
        fun newInstance(dto: CharacterDto) = RemoveFavorDialog().apply {
            arguments = bundleOf(ARG_FAVOR to dto)
        }
    }

    private val character: CharacterDto? by argument(ARG_FAVOR)

    var result: (characterId: Int) -> Unit = {}

    override fun onViewReady(bundle: Bundle?) {
        character?.let {
            binding.tvName.text = it.name
            binding.tvDesc.text = getString(R.string.text_delete_favor_description, it.name)
        }
    }

    override fun onViewListener() {
        super.onViewListener()
        binding.tvCancel.setSafeOnClickListener {
            dismissAllowingStateLoss()
        }

        binding.btnApproveDelete.setSafeOnClickListener {
            dismissAllowingStateLoss()
            character?.let { result.invoke(it.id.orZero()) }
        }
    }
}
