/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.feature.detail

import app.cash.turbine.test
import com.developersancho.domain.usecase.character.GetCharacterDetail
import com.developersancho.framework.core.flow.MutableEventFlow
import com.developersancho.framework.core.network.DataState
import com.developersancho.framework.extensions.getOrAwaitValue
import com.developersancho.model.dto.CharacterDto
import com.developersancho.rorty.features.detail.DetailContract
import com.developersancho.rorty.features.detail.DetailViewModel
import com.developersancho.rorty.provider.ResourceProvider
import com.developersancho.testutils.MockkUnitTest
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import java.io.IOException

class DetailViewModelTest : MockkUnitTest() {

    @MockK(relaxed = true)
    lateinit var getCharacterDetail: GetCharacterDetail

    @MockK(relaxed = true)
    lateinit var resourceProvider: ResourceProvider

    @SpyK
    @InjectMockKs
    lateinit var viewModel: DetailViewModel

    @MockK(relaxed = true)
    var stateObserver = MutableEventFlow<DetailContract.State>()

    @Test
    fun verifyOnTriggerEventLoadDetail() = runTest {
        // Arrange (Given)
        val detailId = 1

        // Act (When)
        viewModel.onTriggerEvent(DetailContract.Event.LoadDetail(detailId))

        // Assert (Then)
        coVerify { getCharacterDetail.invoke(GetCharacterDetail.Params(detailId)) }
    }

    @Test
    fun verifyOnTriggerEventLoadDetail_CheckState() = runTest {
        // Arrange (Given)
        val detailId = 1
        val dto = mockk<CharacterDto>()
        val params = GetCharacterDetail.Params(detailId)
        coEvery { getCharacterDetail.invoke(params) } returns flow {
            emit(DataState.Success(dto))
        }

        // Act (When)
        viewModel.onTriggerEvent(DetailContract.Event.LoadDetail(detailId))

        // Assert (Then)
        viewModel.stateFlow.test {
            awaitItem().apply {
                Truth.assertThat(this).isNotNull()
                Truth.assertThat(this).isInstanceOf(DetailContract.State::class.java)
                Truth.assertThat(this).isEqualTo(DetailContract.State.CharacterDetail(dto))
            }
        }
    }

    @Test
    fun verifyOnTriggerEventLoadDetail_CheckError() = runTest {
        // given
        val detailId = 1
        coEvery { getCharacterDetail(any()) } returns flow {
            emit(DataState.Error(IOException("this is a test exception.")))
        }

        // when
        viewModel.onTriggerEvent(DetailContract.Event.LoadDetail(detailId))

        // then
        coVerify(exactly = 1) { getCharacterDetail(any()) }
        confirmVerified(getCharacterDetail)

        assertThrows<RuntimeException> { viewModel.error.getOrAwaitValue() }
    }
}