/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.favorites

import com.developersancho.model.dto.CharacterDto

class FavoritesContract {
    sealed class Event {
        object LoadFavorite : Event()
        data class DeleteItem(val id: Int) : Event()
    }

    sealed class State {
        data class Favorite(val list: List<CharacterDto>) : State()
    }
}
