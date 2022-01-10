/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.domain.usecase.favorite

import androidx.annotation.VisibleForTesting
import com.developersancho.framework.core.usecase.LocalUseCase
import com.developersancho.framework.extensions.orZero
import com.developersancho.model.dto.CharacterDto
import com.developersancho.model.dto.toFavoriteEntity
import com.developersancho.repository.character.CharacterRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class UpdateFavorite @Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: CharacterRepository
) : LocalUseCase<UpdateFavorite.Params, Unit>() {

    data class Params(
        val character: CharacterDto
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        val dto = params.character
        val character = repository.getFavorite(dto.id.orZero())
        if (character == null) {
            repository.saveFavorite(dto.toFavoriteEntity())
        } else {
            repository.deleteFavoriteById(dto.id.orZero())
        }
        emit(Unit)
    }
}
