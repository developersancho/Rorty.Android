/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.detail

import com.developersancho.framework.core.model.KeyValueModel
import com.developersancho.model.dto.CharacterDto

class DetailContract {
    sealed class Event {
        data class LoadDetail(val id: Int = 0) : Event()
    }

    sealed class State {
        data class CharacterDetail(val detail: CharacterDto) : State()
        data class Detail(val list: List<KeyValueModel>) : State()
    }
}
