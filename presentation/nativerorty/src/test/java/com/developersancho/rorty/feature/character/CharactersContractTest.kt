/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.feature.character

import androidx.paging.PagingData
import com.developersancho.model.dto.CharacterDto
import com.developersancho.rorty.feature.mockdata.FeatureMockData
import com.developersancho.rorty.features.characters.CharactersContract
import org.junit.Assert
import org.junit.Test

class CharactersContractTest {
    private lateinit var event: CharactersContract.Event

    private lateinit var state: CharactersContract.State

    @Test
    fun verifyEventLoadCharacters_ShouldSettledCorrectly() {
        event = CharactersContract.Event.LoadCharacters

        val eventLoadDetail = event as CharactersContract.Event.LoadCharacters
        Assert.assertEquals(event, eventLoadDetail)
    }

    @Test
    fun verifyEventUpdateFavorite_ShouldSettledCorrectly() {
        val dto = FeatureMockData.getCharacterDto()
        event = CharactersContract.Event.UpdateFavorite(dto)

        val eventLoadDetail = event as CharactersContract.Event.UpdateFavorite
        Assert.assertEquals(dto, eventLoadDetail.characterDto)
    }

    @Test
    fun verifyStateCharacters_ShouldSettledCorrectly() {
        val pagedData: PagingData<CharacterDto> = PagingData.empty()
        state = CharactersContract.State.Characters()

        val stateDetail = state as CharactersContract.State.Characters
        Assert.assertEquals(pagedData, stateDetail.pagedData)
    }
}