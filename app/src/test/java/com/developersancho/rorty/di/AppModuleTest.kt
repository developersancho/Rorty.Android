/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.di

import com.developersancho.framework.core.base.application.AppInitializerImpl
import com.developersancho.framework.core.base.application.TimberInitializer
import com.developersancho.rorty.app.RortyApp
import com.developersancho.testutils.MockkUnitTest
import com.google.common.truth.Truth
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class AppModuleTest : MockkUnitTest() {

    private lateinit var module: AppModule

    override fun onCreate() {
        super.onCreate()
        module = AppModule()
    }

    @Test
    fun verifyProvideApplication() {
        val mockRortyApp = mockk<RortyApp>(relaxed = true)
        val rortyApp = module.provideApplication()
        every { mockRortyApp.toString() } returns rortyApp.toString()

        Truth.assertThat(mockRortyApp.toString())
            .isEqualTo(rortyApp.toString())
    }

    @Test
    fun verifyProvideAppConfig() {
        val rortyApp = mockk<RortyApp>(relaxed = true)
        val appConfig = module.provideAppConfig(rortyApp)

        Assert.assertEquals(rortyApp.appConfig(), appConfig)
    }

    @Test
    fun verifyProvideTimberInitializer() {
        val timberInitializer = module.provideTimberInitializer()
        Truth.assertThat(timberInitializer).isInstanceOf(TimberInitializer::class.java)
    }

    @Test
    fun verifyProvideAppInitializer() {
        val mockTimberInitializer = mockk<TimberInitializer>(relaxed = true)
        val appInitializer = module.provideAppInitializer(mockTimberInitializer)

        Truth.assertThat(appInitializer).isInstanceOf(AppInitializerImpl::class.java)
    }
}