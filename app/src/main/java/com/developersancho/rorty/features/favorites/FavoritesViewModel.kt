/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.favorites

import com.developersancho.domain.usecase.favorite.DeleteFavorite
import com.developersancho.domain.usecase.favorite.GetFavorites
import com.developersancho.framework.core.base.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavorites: GetFavorites,
    private val deleteFavorite: DeleteFavorite
) : MviViewModel<FavoritesContract.State, FavoritesContract.Event>() {

    override fun onTriggerEvent(eventType: FavoritesContract.Event) {
        when (eventType) {
            is FavoritesContract.Event.LoadFavorite -> handleLoadFavorite()
            is FavoritesContract.Event.DeleteItem -> handleDeleteItem(eventType.id)
        }
    }

    private fun handleDeleteItem(id: Int) = safeLaunch {
        call(deleteFavorite(DeleteFavorite.Params(id))) {
            onTriggerEvent(FavoritesContract.Event.LoadFavorite)
        }
    }

    private fun handleLoadFavorite() = safeLaunch {
        callWithProgress(getFavorites.invoke(Unit)) {
            setState(FavoritesContract.State.Favorite(it))
        }
    }
}
