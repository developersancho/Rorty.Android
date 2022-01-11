/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.developersancho.components.adapter.swipe.BasicSwipeAdapter
import com.developersancho.components.swipemenulayout.MenuState
import com.developersancho.framework.core.base.binding.toBinding
import com.developersancho.model.dto.CharacterDto
import com.developersancho.model.remote.base.Status
import com.developersancho.rorty.R
import com.developersancho.rorty.databinding.RowFavoriteBinding

class FavoritesAdapter : BasicSwipeAdapter<CharacterDto, RowFavoriteBinding>() {
    var onClickItem: ((CharacterDto) -> Unit)? = null

    fun openPreview() {
        binderHelper.showPreviewSwipe(MenuState.RIGHT_OPEN)
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup): RowFavoriteBinding {
        return parent.toBinding()
    }

    override fun bindView(binding: RowFavoriteBinding, position: Int, item: CharacterDto) {
        binding.ivAvatar.load(item.image.toString()) {
            transformations(RoundedCornersTransformation(16f))
        }
        binding.tvName.text = item.name
        binding.tvSpecies.text = item.species
        binding.tvStatus.setStatus(item.status)
        binding.ivStatus.setStatus(item.status)
        binding.root.setOnClickListener {
            onClickItem?.invoke(item)
        }
    }

    private fun ImageView.setStatus(status: Status?) {
        val statusDrawable = when (status) {
            Status.Alive -> R.drawable.ic_status_circle_green
            Status.Dead -> R.drawable.ic_status_circle_red
            Status.Unknown -> R.drawable.ic_status_circle_gray
            else -> R.drawable.ic_status_circle_gray
        }
        this.load(statusDrawable)
    }

    private fun TextView.setStatus(status: Status?) {
        text = status?.name
    }
}
