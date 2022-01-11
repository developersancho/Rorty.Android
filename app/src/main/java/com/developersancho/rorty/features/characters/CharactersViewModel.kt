/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.characters

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.developersancho.domain.usecase.character.GetCharacters
import com.developersancho.domain.usecase.favorite.UpdateFavorite
import com.developersancho.framework.core.base.mvi.MviViewModel
import com.developersancho.model.dto.CharacterDto
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharacters: GetCharacters,
    private val updateFavorite: UpdateFavorite
) : MviViewModel<CharactersContract.State, CharactersContract.Event>() {
    private val config = PagingConfig(pageSize = 20)

    override fun onTriggerEvent(eventType: CharactersContract.Event) {
        when (eventType) {
            is CharactersContract.Event.LoadCharacters -> loadCharacters()
            is CharactersContract.Event.UpdateFavorite -> updateFavorite(eventType.characterDto)
        }
    }

    private fun loadCharacters() = safeLaunch {
        val params = GetCharacters.Params(config, hashMapOf())
        getCharacters(params).cachedIn(scope = viewModelScope)
            .collect {
                setState(CharactersContract.State.Characters(it))
            }
    }

    private fun updateFavorite(dto: CharacterDto) = safeLaunch {
        val params = UpdateFavorite.Params(dto)
        call(updateFavorite(params))
    }
}