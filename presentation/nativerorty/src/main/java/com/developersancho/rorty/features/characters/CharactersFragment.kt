/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.characters

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.developersancho.components.adapter.paging.PagingLoadStateAdapter
import com.developersancho.framework.extensions.observeFlow
import com.developersancho.framework.extensions.orZero
import com.developersancho.framework.extensions.setItemDecoration
import com.developersancho.rorty.base.mvi.BaseMviFragment
import com.developersancho.rorty.databinding.FragmentCharactersBinding
import com.developersancho.rorty.provider.NavigationProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharactersFragment :
    BaseMviFragment<FragmentCharactersBinding, CharactersContract.State, CharactersViewModel>() {
    companion object {
        @JvmStatic
        fun newInstance() = CharactersFragment()
    }

    @Inject
    lateinit var navigationProvider: NavigationProvider

    private val adapter = CharactersAdapter()

    override val viewModel: CharactersViewModel by viewModels()

    override fun onViewReady(bundle: Bundle?) {
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvCharacters.setHasFixedSize(true)
        binding.rvCharacters.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCharacters.setItemDecoration(left = 8, top = 12, right = 8, bottom = 0)
        binding.rvCharacters.adapter = adapter.withLoadStateHeaderAndFooter(
            header = PagingLoadStateAdapter(adapter),
            footer = PagingLoadStateAdapter(adapter)
        )
        binding.swrCharacters.setOnRefreshListener { adapter.refresh() }
        adapter.onClickItem = {
            navigationProvider.launchDetailFragment(this, it.id.orZero())
        }
        adapter.onClickFavorite = {
            viewModel.onTriggerEvent(CharactersContract.Event.UpdateFavorite(it))
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onTriggerEvent(CharactersContract.Event.LoadCharacters)
    }

    override fun renderViewState(viewState: CharactersContract.State) {
        when (viewState) {
            is CharactersContract.State.Characters -> {
                adapter.submitData(lifecycle, viewState.pagedData)
            }
        }
    }

    override fun observeUi() {
        super.observeUi()
        observeFlow(adapter.loadStateFlow) {
            binding.swrCharacters.isRefreshing = it.refresh is LoadState.Loading
        }
    }
}