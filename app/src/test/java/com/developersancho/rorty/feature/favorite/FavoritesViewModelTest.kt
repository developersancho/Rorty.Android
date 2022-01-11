/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.feature.favorite

import app.cash.turbine.test
import com.developersancho.domain.usecase.favorite.DeleteFavorite
import com.developersancho.domain.usecase.favorite.GetFavorites
import com.developersancho.model.dto.CharacterDto
import com.developersancho.rorty.features.favorites.FavoritesContract
import com.developersancho.rorty.features.favorites.FavoritesViewModel
import com.developersancho.testutils.MockkUnitTest
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test

class FavoritesViewModelTest : MockkUnitTest() {
    @RelaxedMockK
    lateinit var getFavorites: GetFavorites

    @RelaxedMockK
    lateinit var deleteFavorite: DeleteFavorite

    @SpyK
    @InjectMockKs
    lateinit var viewModel: FavoritesViewModel

    @Test
    fun verifyOnTriggerEventLoadFavorite() = runTest {
        // Arrange (Given)

        // Act (When)
        viewModel.onTriggerEvent(FavoritesContract.Event.LoadFavorite)

        // Assert (Then)
        coVerify { getFavorites.invoke(Unit) }
    }

    @Test
    fun verifyOnTriggerEventDeleteItem() = runTest {
        // Arrange (Given)
        val itemId = 1

        // Act (When)
        viewModel.onTriggerEvent(FavoritesContract.Event.DeleteItem(itemId))

        // Assert (Then)
        coVerify { deleteFavorite.invoke(DeleteFavorite.Params(itemId)) }
    }

    @Test
    fun verifyOnTriggerEventLoadFavorite_CheckState() = runTest {
        // Arrange (Given)
        val dtoList = mockk<List<CharacterDto>>()
        coEvery { getFavorites.invoke(Unit) } returns flow { emit(dtoList) }

        // Act (When)
        viewModel.onTriggerEvent(FavoritesContract.Event.LoadFavorite)

        // Assert (Then)
        viewModel.stateFlow.test {
            awaitItem().apply {
                Truth.assertThat(this).isNotNull()
                Truth.assertThat(this).isInstanceOf(FavoritesContract.State::class.java)
                Truth.assertThat(this).isEqualTo(FavoritesContract.State.Favorite(dtoList))
            }
        }
    }

    @Test
    fun verifyOnTriggerEventDeleteItem_CheckState() = runTest {
        // Arrange (Given)
        val characterId = 1
        coEvery { deleteFavorite.invoke(DeleteFavorite.Params(characterId)) } returns flow { emit(Unit) }

        // Act (When)
        viewModel.onTriggerEvent(FavoritesContract.Event.DeleteItem(characterId))

        // Assert (Then)
        verify { viewModel.onTriggerEvent(FavoritesContract.Event.LoadFavorite) }
    }
}