/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.features.detail

import com.developersancho.domain.usecase.character.GetCharacterDetail
import com.developersancho.framework.core.base.mvi.MviViewModel
import com.developersancho.framework.core.model.KeyValueModel
import com.developersancho.model.dto.CharacterDto
import com.developersancho.rorty.R
import com.developersancho.rorty.provider.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCharacterDetail: GetCharacterDetail,
    private val resourceProvider: ResourceProvider
) : MviViewModel<DetailContract.State, DetailContract.Event>() {

    private var characterDto: CharacterDto? = null

    override fun onTriggerEvent(eventType: DetailContract.Event) {
        when (eventType) {
            is DetailContract.Event.LoadDetail -> loadDetail(eventType.id)
        }
    }

    private fun loadDetail(id: Int) = safeLaunch {
        val params = GetCharacterDetail.Params(detailId = id)
        executeWithProgress(getCharacterDetail(params)) { character ->
            this@DetailViewModel.characterDto = character
            setState(DetailContract.State.CharacterDetail(character))
            setState(DetailContract.State.Detail(getDetails(character)))
        }
    }

    private fun getDetails(character: CharacterDto): List<KeyValueModel> {
        val list = mutableListOf<KeyValueModel>()
        list.add(
            KeyValueModel(
                key = resourceProvider.getString(R.string.text_name),
                value = character.name
            )
        )
        list.add(
            KeyValueModel(
                key = resourceProvider.getString(R.string.text_species),
                value = character.species
            )
        )
        list.add(
            KeyValueModel(
                key = resourceProvider.getString(R.string.text_gender),
                value = character.gender
            )
        )
        list.add(
            KeyValueModel(
                key = resourceProvider.getString(R.string.text_last_know_location),
                value = character.origin?.name
            )
        )
        list.add(
            KeyValueModel(
                key = resourceProvider.getString(R.string.text_location),
                value = character.location?.name
            )
        )

        return list
    }
}