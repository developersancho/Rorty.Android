/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.di

import com.developersancho.framework.core.base.application.CoreConfig
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
}