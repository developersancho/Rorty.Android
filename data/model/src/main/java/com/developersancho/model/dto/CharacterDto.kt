/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.model.dto

import android.os.Parcelable
import com.developersancho.model.remote.base.Status
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterDto(
    val created: String?,
    val episode: List<String>?,
    val gender: String?,
    val id: Int?,
    val image: String?,
    val location: LocationDto?,
    val name: String?,
    val origin: LocationDto?,
    val species: String?,
    val status: Status?,
    val type: String?,
    val url: String?,
    var isFavorite: Boolean = false
) : Parcelable
