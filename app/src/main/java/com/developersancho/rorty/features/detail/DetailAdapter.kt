/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.developersancho.framework.core.adapter.BasicRecyclerAdapter
import com.developersancho.framework.core.base.binding.toBinding
import com.developersancho.framework.core.model.KeyValueModel
import com.developersancho.rorty.databinding.RowDetailBinding

class DetailAdapter : BasicRecyclerAdapter<KeyValueModel, RowDetailBinding>() {

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup): RowDetailBinding {
        return parent.toBinding()
    }

    override fun bindView(binding: RowDetailBinding, position: Int, item: KeyValueModel) {
        binding.tvKey.text = item.key
        binding.tvValue.text = item.value
    }
}
