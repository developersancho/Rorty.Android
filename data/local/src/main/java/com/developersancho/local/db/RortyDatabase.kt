/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.developersancho.framework.core.room.converter.StringConverter
import com.developersancho.local.dao.FavoriteDao
import com.developersancho.model.local.FavoriteEntity

@Database(
    entities = [FavoriteEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(StringConverter::class)
abstract class RortyDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
