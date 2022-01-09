/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.model.local

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.developersancho.model.remote.base.Status

@Entity(tableName = FavoriteEntity.TABLE_NAME)
data class FavoriteEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = COLUMN_ID) val id: Int,
    @ColumnInfo(name = COLUMN_NAME) val name: String,
    @ColumnInfo(name = COLUMN_IMAGE_URL) val imageUrl: String,
    @ColumnInfo(name = COLUMN_CREATED) val created: String,
    @Embedded(prefix = PREF_ORIGIN) val origin: LocationEntity?,
    @Embedded(prefix = PREF_LOCATION) val location: LocationEntity?,
    @ColumnInfo(name = COLUMN_STATUS) val status: Status,
    @ColumnInfo(name = COLUMN_SPECIES) val species: String,
    @ColumnInfo(name = COLUMN_GENDER) val gender: String,
    @ColumnInfo(name = COLUMN_TYPE) val type: String,
    @ColumnInfo(name = COLUMN_URL) val url: String,
    @ColumnInfo(name = COLUMN_EPISODE) val episode: List<String>
) {
    companion object {
        const val TABLE_NAME = "favorite"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_IMAGE_URL = "image_url"
        const val COLUMN_CREATED = "created"
        const val PREF_ORIGIN = "origin_"
        const val PREF_LOCATION = "location_"
        const val COLUMN_STATUS = "status"
        const val COLUMN_SPECIES = "species"
        const val COLUMN_GENDER = "gender"
        const val COLUMN_TYPE = "type"
        const val COLUMN_URL = "url"
        const val COLUMN_EPISODE = "episode"
    }
}
