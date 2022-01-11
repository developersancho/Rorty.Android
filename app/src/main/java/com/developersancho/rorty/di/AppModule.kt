/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.di

import com.developersancho.framework.core.base.application.AppInitializer
import com.developersancho.framework.core.base.application.AppInitializerImpl
import com.developersancho.framework.core.base.application.CoreConfig
import com.developersancho.framework.core.base.application.TimberInitializer
import com.developersancho.rorty.app.RortyApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideApplication(): RortyApp {
        return RortyApp()
    }

    @Provides
    @Singleton
    fun provideAppConfig(app: RortyApp): CoreConfig {
        return app.appConfig()
    }

    @Provides
    @Singleton
    fun provideTimberInitializer() = TimberInitializer()

    @Provides
    @Singleton
    fun provideAppInitializer(timberManager: TimberInitializer): AppInitializer {
        return AppInitializerImpl(timberManager)
    }
}