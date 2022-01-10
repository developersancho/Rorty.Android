/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.favorites

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.developersancho.components.swipemenulayout.SwipeMenuItem
import com.developersancho.components.swipemenulayout.menuItems
import com.developersancho.framework.core.font.FontCache
import com.developersancho.framework.extensions.orZero
import com.developersancho.framework.extensions.setItemDecoration
import com.developersancho.model.dto.CharacterDto
import com.developersancho.rorty.R
import com.developersancho.rorty.base.mvi.BaseMviFragment
import com.developersancho.rorty.databinding.FragmentFavoritesBinding
import com.developersancho.rorty.provider.NavigationProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoritesFragment :
    BaseMviFragment<FragmentFavoritesBinding, FavoritesContract.State, FavoritesViewModel>() {

    companion object {
        @JvmStatic
        fun newInstance() = FavoritesFragment()
    }

    @Inject
    lateinit var navigationProvider: NavigationProvider

    private val adapter = FavoritesAdapter()

    override val viewModel: FavoritesViewModel by viewModels()

    override fun onViewReady(bundle: Bundle?) {
        initAdapter()
    }

    override fun renderViewState(viewState: FavoritesContract.State) {
        when (viewState) {
            is FavoritesContract.State.Favorite -> {
                adapter.setItems(viewState.list)
                adapter.openPreview()
            }
        }
    }

    private fun initAdapter() {
        binding.rvFavorites.setHasFixedSize(true)
        binding.rvFavorites.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavorites.setItemDecoration(left = 8, top = 12, right = 8, bottom = 0)
        binding.rvFavorites.adapter = adapter
        adapter.rightSwipeMenus = getRightMenus()
        adapter.onClickItem = {
            navigationProvider.launchDetailFragment(this, it.id.orZero())
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onTriggerEvent(FavoritesContract.Event.LoadFavorite)
    }

    private fun getRightMenus(): List<SwipeMenuItem> {
        return menuItems {
            menuItem {
                width = 80
                height = ViewGroup.LayoutParams.MATCH_PARENT
                orientation = LinearLayoutCompat.VERTICAL
                title = getString(R.string.text_remove)
                titleSize = 14
                titleColor = R.color.white
                iconRes = R.drawable.ic_trash
                backgroundColor = R.color.red_primary_dark
                textTypeface = FontCache[R.font.raleway_semi_bold, requireContext()]
                menuItemClick = { position ->
                    showDeleteDialog(adapter.getItem(position))
                }
            }
        }
    }

    private fun showDeleteDialog(dto: CharacterDto) {
        val dialog = RemoveFavorDialog.newInstance(dto)
        dialog.show(childFragmentManager, dialog.tag)
        dialog.result = { characterId: Int ->
            viewModel.onTriggerEvent(
                FavoritesContract.Event.DeleteItem(characterId)
            )
        }
    }
}