/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.remote.service.episode

import com.developersancho.remote.BuildConfig
import com.developersancho.remote.service.EpisodeService
import com.developersancho.remote.service.mock.MockResponses
import com.developersancho.testutils.BaseServiceTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class EpisodeServiceTest : BaseServiceTest<EpisodeService>(EpisodeService::class) {

    override val baseUrl: String
        get() = BuildConfig.BASE_URL

    /**
     * Get Episode List
     */
    @Test
    fun requestLiveGetEpisodes() = runBlocking {
        val response = serviceLive.getEpisodeList(page = 1, options = hashMapOf())
        Assert.assertEquals(1, response.results?.first()?.id)
        Assert.assertEquals("Pilot", response.results?.first()?.name)
        Assert.assertEquals("S01E01", response.results?.first()?.episode)
    }

    @Test
    fun requestGetEpisodes() = runBlocking {
        enqueueResponse(MockResponses.GetEpisodes.STATUS_200)
        serviceMock.getEpisodeList(page = 1, options = hashMapOf())
        val request = mockWebServer.takeRequest()
        Assert.assertEquals("GET", request.method)
        Assert.assertEquals("/episode?page=1", request.path)
    }

    @Test
    fun responseGetEpisodes() = runBlocking {
        enqueueResponse(MockResponses.GetEpisodes.STATUS_200)
        val response = serviceMock.getEpisodeList(page = 1, options = hashMapOf())
        Assert.assertEquals(1, response.results?.first()?.id)
        Assert.assertEquals("Pilot", response.results?.first()?.name)
        Assert.assertEquals("S01E01", response.results?.first()?.episode)
    }

    /**
     * Get Episode List by Filter
     */
    @Test
    fun requestLiveGetEpisodesByFilter() = runBlocking {
        val response = serviceLive.getEpisodeList(
            page = 1,
            options = hashMapOf(
                "name" to "Pilot"
            )
        )
        Assert.assertEquals(1, response.results?.first()?.id)
        Assert.assertEquals("Pilot", response.results?.first()?.name)
        Assert.assertEquals("S01E01", response.results?.first()?.episode)
    }

    @Test
    fun requestGetEpisodesByFilter() = runBlocking {
        enqueueResponse(MockResponses.GetEpisodesByFilter.STATUS_200)
        serviceMock.getEpisodeList(
            page = 1,
            options = hashMapOf(
                "name" to "Pilot"
            )
        )
        val request = mockWebServer.takeRequest()
        Assert.assertEquals("GET", request.method)
        Assert.assertEquals("/episode?page=1&name=Pilot", request.path)
    }

    @Test
    fun responseGetEpisodesByFilter() = runBlocking {
        enqueueResponse(MockResponses.GetEpisodesByFilter.STATUS_200)
        val response = serviceMock.getEpisodeList(
            page = 1,
            options = hashMapOf(
                "name" to "Pilot"
            )
        )
        Assert.assertEquals(1, response.results?.first()?.id)
        Assert.assertEquals("Pilot", response.results?.first()?.name)
        Assert.assertEquals("S01E01", response.results?.first()?.episode)
    }

    /**
     * Get Episode
     */
    @Test
    fun requestLiveGetEpisode() = runBlocking {
        val response = serviceLive.getEpisode(episodeId = 1)
        Assert.assertEquals(1, response.id)
        Assert.assertEquals("Pilot", response.name)
        Assert.assertEquals("S01E01", response.episode)
    }

    @Test
    fun requestGetEpisode() = runBlocking {
        enqueueResponse(MockResponses.GetEpisode.STATUS_200)
        serviceMock.getEpisode(episodeId = 1)
        val request = mockWebServer.takeRequest()
        Assert.assertEquals("GET", request.method)
        Assert.assertEquals("/episode/1", request.path)
    }

    @Test
    fun responseGetEpisode() = runBlocking {
        enqueueResponse(MockResponses.GetEpisode.STATUS_200)
        val response = serviceMock.getEpisode(episodeId = 1)
        Assert.assertEquals(1, response.id)
        Assert.assertEquals("Pilot", response.name)
        Assert.assertEquals("S01E01", response.episode)
    }
}