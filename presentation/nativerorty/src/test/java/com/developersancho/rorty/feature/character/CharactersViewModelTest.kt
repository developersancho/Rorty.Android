/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.feature.character

import androidx.paging.PagingData
import app.cash.turbine.test
import com.developersancho.domain.usecase.character.GetCharacters
import com.developersancho.domain.usecase.favorite.UpdateFavorite
import com.developersancho.rorty.feature.mockdata.FeatureMockData
import com.developersancho.rorty.features.characters.CharactersContract
import com.developersancho.rorty.features.characters.CharactersViewModel
import com.developersancho.testutils.MockkUnitTest
import com.google.common.truth.Truth
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test

class CharactersViewModelTest : MockkUnitTest() {

    @MockK(relaxed = true)
    lateinit var getCharacters: GetCharacters

    @MockK(relaxed = true)
    lateinit var updateFavorite: UpdateFavorite

    @InjectMockKs
    lateinit var options: HashMap<String, String>

    @SpyK
    @InjectMockKs
    lateinit var viewModel: CharactersViewModel

    @Test
    fun verifyOnTriggerEventLoadCharacters() = runTest {
        // Arrange (Given)
        every { getCharacters.invoke(any()) } returns flow {
            emit(PagingData.from(FeatureMockData.getCharacterDtoList()))
        }

        // Act (When)
        viewModel.onTriggerEvent(CharactersContract.Event.LoadCharacters)

        // Assert (Then)
        verify { getCharacters.invoke(any()) }
    }

    @Test
    fun verifyOnTriggerEventUpdateFavorite() = runTest {
        // Arrange (Given)
        val dto = FeatureMockData.getCharacterDto()

        // Act (When)
        viewModel.onTriggerEvent(CharactersContract.Event.UpdateFavorite(dto))

        // Assert (Then)
        coVerify { updateFavorite(UpdateFavorite.Params(dto)) }
    }

    @Test
    fun verifyOnTriggerEventLoadCharacters_CheckState() = runTest {
        // Arrange (Given)
        val response = PagingData.from(FeatureMockData.getCharacterDtoList())
        every { getCharacters(any()) } returns flow { emit(response) }

        // Act (When)
        viewModel.onTriggerEvent(CharactersContract.Event.LoadCharacters)

        // Assert (Then)
        viewModel.stateFlow.test {
            awaitItem().apply {
                Truth.assertThat(this).isNotNull()
                Truth.assertThat(this).isInstanceOf(CharactersContract.State::class.java)
            }
        }
    }
}