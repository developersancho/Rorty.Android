/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.repository.di

import android.annotation.SuppressLint
import com.developersancho.local.dao.FavoriteDao
import com.developersancho.remote.service.CharacterService
import com.developersancho.remote.service.EpisodeService
import com.developersancho.remote.service.LocationService
import com.developersancho.repository.character.CharacterRepository
import com.developersancho.repository.episode.EpisodeRepository
import com.developersancho.repository.location.LocationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressLint("VisibleForTests")
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideCharacterRepository(
        service: CharacterService,
        dao: FavoriteDao
    ) = CharacterRepository(service, dao)

    @Singleton
    @Provides
    fun provideEpisodeRepository(service: EpisodeService) = EpisodeRepository(service)

    @Singleton
    @Provides
    fun provideLocationRepository(service: LocationService) = LocationRepository(service)
}
