/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.domain.usecase.character

import androidx.annotation.VisibleForTesting
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.developersancho.framework.core.usecase.FlowPagingUseCase
import com.developersancho.model.dto.CharacterDto
import com.developersancho.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacters @Inject constructor(
    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: CharacterRepository
) : FlowPagingUseCase<GetCharacters.Params, CharacterDto>() {

    data class Params(
        val pagingConfig: PagingConfig,
        val options: Map<String, String>
    )

    override fun execute(params: Params): Flow<PagingData<CharacterDto>> {
        return Pager(
            config = params.pagingConfig,
            pagingSourceFactory = { CharacterPagingSource(repository, params.options) }
        ).flow
    }
}
