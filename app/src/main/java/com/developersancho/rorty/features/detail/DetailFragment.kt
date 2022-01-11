/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import coil.load
import coil.transform.RoundedCornersTransformation
import com.developersancho.framework.extensions.addDividerDrawable
import com.developersancho.framework.extensions.argument
import com.developersancho.framework.extensions.drawable
import com.developersancho.framework.extensions.orZero
import com.developersancho.model.remote.base.Status
import com.developersancho.rorty.R
import com.developersancho.rorty.base.mvi.BaseMviFragment
import com.developersancho.rorty.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment :
    BaseMviFragment<FragmentDetailBinding, DetailContract.State, DetailViewModel>() {
    companion object {
        private const val ARG_DETAIL_ID = "arg_detail_id"

        @JvmStatic
        fun newInstance(detailId: Int) = DetailFragment().apply {
            arguments = bundleOf(ARG_DETAIL_ID to detailId)
        }
    }

    private val detailId: Int by argument(ARG_DETAIL_ID)

    private val adapter = DetailAdapter()

    override val viewModel: DetailViewModel by viewModels()

    override fun onViewReady(bundle: Bundle?) {
        val detailId = detailId.orZero()
        initAdapter()
        viewModel.onTriggerEvent(DetailContract.Event.LoadDetail(detailId))
    }

    private fun initAdapter() {
        val divider = context?.drawable(R.drawable.divider_vertical_with_margin)
        divider?.let { binding.rvDetail.addDividerDrawable(it) }
        binding.rvDetail.adapter = adapter
    }

    override fun onViewListener() {
        super.onViewListener()
        binding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun renderViewState(viewState: DetailContract.State) {
        when (viewState) {
            is DetailContract.State.CharacterDetail -> {
                val detail = viewState.detail
                binding.ivAvatar.load(detail.image.orEmpty()) {
                    transformations(RoundedCornersTransformation(25f))
                }
                binding.tvStatus.setStatus(detail.status)
                binding.ivStatus.setStatus(detail.status)
            }
            is DetailContract.State.Detail -> {
                adapter.setItems(viewState.list)
            }
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