/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.remote.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.developersancho.framework.core.base.application.CoreConfig
import com.developersancho.framework.core.base.application.CoreEnvironment
import com.developersancho.framework.core.network.interceptor.HttpRequestInterceptor
import com.developersancho.remote.BuildConfig
import com.developersancho.remote.service.CharacterService
import com.developersancho.remote.service.EpisodeService
import com.developersancho.remote.service.LocationService
import com.developersancho.testutils.MockkUnitTest
import com.google.common.truth.Truth
import com.squareup.moshi.Moshi
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Assert
import org.junit.Test
import retrofit2.Retrofit

class RemoteModuleTest: MockkUnitTest() {

    private lateinit var remoteModule: RemoteModule
    private lateinit var appConfig: CoreConfig

    override fun onCreate() {
        super.onCreate()
        appConfig = object : CoreConfig() {
            override fun appName(): String = "Remote Module"
            override fun environment(): CoreEnvironment = CoreEnvironment.DEV
            override fun baseUrl(): String = BuildConfig.BASE_URL
            override fun timeOut(): Long = 30L
            override fun isDev(): Boolean = environment() == CoreEnvironment.DEV
        }
        remoteModule = RemoteModule()
    }

    @Test
    fun verifyBaseUrl() {
        val baseUrl = remoteModule.provideBaseUrl(appConfig)
        Assert.assertEquals(baseUrl, BuildConfig.BASE_URL)
    }

    @Test
    fun verifyProvideHttpLoggingInterceptor() {
        val interceptor = remoteModule.provideHttpLoggingInterceptor(appConfig)
        Assert.assertEquals(HttpLoggingInterceptor.Level.BODY, interceptor.level)
    }

    @Test
    fun verifyProvideHttpRequestInterceptor() {
        val interceptor = remoteModule.provideHttpRequestInterceptor()
        Truth.assertThat(interceptor).isInstanceOf(HttpRequestInterceptor::class.java)
    }

    @Test
    fun verifyProvideOkHttpClient() {
        val loggingInterceptor = mockk<HttpLoggingInterceptor>()
        val chuckerInterceptor = mockk<ChuckerInterceptor>()
        val httpRequestInterceptor = mockk<HttpRequestInterceptor>()
        val httpClient = remoteModule.provideOkHttpClient(
            appConfig,
            loggingInterceptor,
            chuckerInterceptor,
            httpRequestInterceptor
        )

        Assert.assertEquals(3, httpClient.interceptors.size)
        Assert.assertEquals(loggingInterceptor, httpClient.interceptors.first())
        Assert.assertEquals(httpRequestInterceptor, httpClient.interceptors.last())
    }

    @Test
    fun verifyProvidedRetrofit() {
        val baseUrl = remoteModule.provideBaseUrl(appConfig)
        val httpClient = mockk<OkHttpClient>()
        val moshi = mockk<Moshi>()
        val retrofit = remoteModule.provideRetrofit(baseUrl, httpClient, moshi)

        Assert.assertEquals(baseUrl, retrofit.baseUrl().toString())
    }

    @Test
    fun verifyProvideCharacterService() {
        val retrofit = mockk<Retrofit>()
        val service = mockk<CharacterService>()
        val serviceClassCaptor = slot<Class<*>>()

        every { retrofit.create<CharacterService>(any()) } returns service

        remoteModule.provideCharacterService(retrofit)

        verify { retrofit.create(capture(serviceClassCaptor)) }
        Assert.assertEquals(CharacterService::class.java, serviceClassCaptor.captured)
    }

    @Test
    fun verifyProvideEpisodeService() {
        val retrofit = mockk<Retrofit>()
        val service = mockk<EpisodeService>()
        val serviceClassCaptor = slot<Class<*>>()

        every { retrofit.create<EpisodeService>(any()) } returns service

        remoteModule.provideEpisodeService(retrofit)

        verify { retrofit.create(capture(serviceClassCaptor)) }
        Assert.assertEquals(EpisodeService::class.java, serviceClassCaptor.captured)
    }

    @Test
    fun verifyProvideLocationService() {
        val retrofit = mockk<Retrofit>()
        val service = mockk<LocationService>()
        val serviceClassCaptor = slot<Class<*>>()

        every { retrofit.create<LocationService>(any()) } returns service

        remoteModule.provideLocationService(retrofit)

        verify { retrofit.create(capture(serviceClassCaptor)) }
        Assert.assertEquals(LocationService::class.java, serviceClassCaptor.captured)
    }
}