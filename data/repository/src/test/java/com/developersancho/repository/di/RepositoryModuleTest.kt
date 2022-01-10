/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.repository.di

import com.developersancho.local.dao.FavoriteDao
import com.developersancho.remote.service.CharacterService
import com.developersancho.remote.service.EpisodeService
import com.developersancho.remote.service.LocationService
import com.developersancho.testutils.MockkUnitTest
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class RepositoryModuleTest : MockkUnitTest() {

    private lateinit var repositoryModule: RepositoryModule

    override fun onCreate() {
        super.onCreate()
        repositoryModule = RepositoryModule()
    }

    @Test
    fun verifyProvideCharacterRepository() {
        val service = mockk<CharacterService>()
        val dao = mockk<FavoriteDao>()
        val repository = repositoryModule.provideCharacterRepository(service, dao)

        Assert.assertEquals(service, repository.service)
    }

    @Test
    fun verifyProvideEpisodeRepository() {
        val service = mockk<EpisodeService>()
        val repository = repositoryModule.provideEpisodeRepository(service)

        Assert.assertEquals(service, repository.service)
    }

    @Test
    fun verifyProvideLocationRepository() {
        val service = mockk<LocationService>()
        val repository = repositoryModule.provideLocationRepository(service)

        Assert.assertEquals(service, repository.service)
    }
}