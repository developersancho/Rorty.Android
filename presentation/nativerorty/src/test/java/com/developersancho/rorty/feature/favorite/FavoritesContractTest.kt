/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.feature.favorite

import com.developersancho.rorty.feature.mockdata.FeatureMockData
import com.developersancho.rorty.features.favorites.FavoritesContract
import org.junit.Assert
import org.junit.Test

class FavoritesContractTest {

    private lateinit var event: FavoritesContract.Event

    private lateinit var state: FavoritesContract.State

    @Test
    fun verifyEventLoadFavorite_ShouldSettledCorrectly() {
        event = FavoritesContract.Event.LoadFavorite

        val eventLoadFavorite = event as FavoritesContract.Event.LoadFavorite
        Assert.assertEquals(event, eventLoadFavorite)
    }

    @Test
    fun verifyEventDeleteItem_ShouldSettledCorrectly() {
        val itemId = 1
        event = FavoritesContract.Event.DeleteItem(itemId)

        val eventDeleteItem = event as FavoritesContract.Event.DeleteItem
        Assert.assertEquals(itemId, eventDeleteItem.id)
    }

    @Test
    fun verifyStateDetail_ShouldSettledCorrectly() {
        val list = FeatureMockData.getCharacterDtoList()
        state = FavoritesContract.State.Favorite(list)

        val stateFavorite = state as FavoritesContract.State.Favorite
        Assert.assertEquals(list, stateFavorite.list)
    }
}