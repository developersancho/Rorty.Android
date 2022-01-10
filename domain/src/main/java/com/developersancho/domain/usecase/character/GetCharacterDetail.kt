/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.domain.usecase.character

import androidx.annotation.VisibleForTesting
import com.developersancho.framework.core.network.DataState
import com.developersancho.framework.core.network.apiCall
import com.developersancho.framework.core.usecase.DataStateUseCase
import com.developersancho.framework.extensions.orZero
import com.developersancho.model.dto.CharacterDto
import com.developersancho.model.dto.toCharacterDto
import com.developersancho.repository.character.CharacterRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetCharacterDetail
@Inject
constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: CharacterRepository
) : DataStateUseCase<GetCharacterDetail.Params, CharacterDto>() {

    data class Params(
        val detailId: Int
    )

    override suspend fun FlowCollector<DataState<CharacterDto>>.execute(params: Params) {
        val service = apiCall {
            repository.getCharacter(characterId = params.detailId).toCharacterDto()
        }
        service.map {
            val characterFav = repository.getFavorite(it.id.orZero())
            it.isFavorite = characterFav != null
        }
        emit(service)
    }
}
