/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.characters

import androidx.paging.PagingData
import com.developersancho.model.dto.CharacterDto

class CharactersContract {
    sealed class Event {
        object LoadCharacters : Event()
        data class UpdateFavorite(val characterDto: CharacterDto) : Event()
    }

    sealed class State {
        data class Characters(val pagedData: PagingData<CharacterDto> = PagingData.empty()) : State()
    }
}
