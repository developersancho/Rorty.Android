/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.feature.detail

import com.developersancho.framework.core.model.KeyValueModel
import com.developersancho.rorty.feature.mockdata.FeatureMockData
import com.developersancho.rorty.features.detail.DetailContract
import org.junit.Assert
import org.junit.Test

class DetailContractTest {

    private lateinit var event: DetailContract.Event

    private lateinit var state: DetailContract.State

    @Test
    fun verifyEventLoadDetail_ShouldSettledCorrectly() {
        val characterId = 1
        event = DetailContract.Event.LoadDetail(characterId)

        val eventLoadDetail = event as DetailContract.Event.LoadDetail
        Assert.assertEquals(characterId, eventLoadDetail.id)
    }

    @Test
    fun verifyStateCharacterDetail_ShouldSettledCorrectly() {
        val dto = FeatureMockData.getCharacterDto()
        state = DetailContract.State.CharacterDetail(dto)

        val stateCharacterDetail = state as DetailContract.State.CharacterDetail
        Assert.assertEquals(dto, stateCharacterDetail.detail)
    }

    @Test
    fun verifyStateDetail_ShouldSettledCorrectly() {
        val details = listOf(KeyValueModel(key = null, value = null))
        state = DetailContract.State.Detail(details)

        val stateDetail = state as DetailContract.State.Detail
        Assert.assertEquals(details, stateDetail.list)
    }
}