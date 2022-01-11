/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.characters

import android.graphics.PorterDuff
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.developersancho.framework.core.base.binding.BindingViewHolder
import com.developersancho.framework.core.base.binding.toBinding
import com.developersancho.framework.extensions.cast
import com.developersancho.framework.extensions.color
import com.developersancho.model.dto.CharacterDto
import com.developersancho.rorty.R
import com.developersancho.rorty.databinding.RowCharacterBinding

class CharactersAdapter : PagingDataAdapter<CharacterDto, RecyclerView.ViewHolder>(
    CharactersComparator
) {
    companion object CharactersComparator : DiffUtil.ItemCallback<CharacterDto>() {
        override fun areItemsTheSame(oldItem: CharacterDto, newItem: CharacterDto) =
            oldItem.id == newItem.id && oldItem.isFavorite == newItem.isFavorite

        override fun areContentsTheSame(oldItem: CharacterDto, newItem: CharacterDto) =
            oldItem == newItem
    }

    var onClickItem: ((CharacterDto) -> Unit)? = null
    var onClickFavorite: ((CharacterDto) -> Unit)? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val character = getItem(position)
        character?.let { holder.cast<CharactersViewHolder>().bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CharactersViewHolder(parent.toBinding())
    }

    inner class CharactersViewHolder(binding: RowCharacterBinding) :
        BindingViewHolder<RowCharacterBinding>(binding) {

        fun bind(item: CharacterDto) {
            binding.card.animation = AnimationUtils.loadAnimation(context, R.anim.down_to_up)

            binding.ivAvatar.apply {
                transitionName = item.image
                load(item.image.toString()) {
                    transformations(RoundedCornersTransformation(16f))
                }
            }
            binding.tvName.text = item.name
            binding.tvSpecies.text = item.species
            binding.tvStatus.setStatus(item.status)
            binding.ivStatus.setStatus(item.status)

            if (item.isFavorite) {
                binding.btnFavorite.setColorFilter(
                    context.color(R.color.red_700),
                    PorterDuff.Mode.MULTIPLY
                )
            } else {
                binding.btnFavorite.setColorFilter(
                    context.color(R.color.grey_700),
                    PorterDuff.Mode.MULTIPLY
                )
            }

            binding.btnFavorite.setOnClickListener {
                item.isFavorite = !item.isFavorite
                binding.btnFavorite.startAnimation(item.isFavorite) {
                    onClickFavorite?.invoke(item)
                }
            }

            binding.root.setOnClickListener {
                onClickItem?.invoke(item)
            }
        }
    }
}
