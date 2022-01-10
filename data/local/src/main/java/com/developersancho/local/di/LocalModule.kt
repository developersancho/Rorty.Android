/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.local.di

import android.content.Context
import androidx.room.Room
import com.developersancho.local.BuildConfig
import com.developersancho.local.dao.FavoriteDao
import com.developersancho.local.db.RortyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

private const val DB_NAME = "db_name"

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {
    @Provides
    @Singleton
    @Named(value = DB_NAME)
    fun provideDatabaseName(): String {
        return BuildConfig.DB_NAME
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @Named(value = DB_NAME) dbname: String,
        @ApplicationContext context: Context
    ): RortyDatabase {
        return Room.databaseBuilder(context, RortyDatabase::class.java, dbname)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideFavoriteDao(appDatabase: RortyDatabase): FavoriteDao {
        return appDatabase.favoriteDao()
    }
}
