/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.di

import android.content.Context
import com.developersancho.rorty.provider.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProviderModule {
    @Provides
    @Singleton
    fun provideNavigationProviderImpl(@ApplicationContext context: Context): NavigationProvider {
        return NavigationProviderImpl(context)
    }

    @Provides
    @Singleton
    fun provideResourceProviderImpl(@ApplicationContext context: Context): ResourceProvider {
        return ResourceProviderImpl(context)
    }

    @Provides
    @Singleton
    fun provideThemeProviderImpl(): ThemeProvider {
        return ThemeProviderImpl()
    }

    @Provides
    @Singleton
    fun provideAppProviderImpl(@ApplicationContext context: Context): AppProvider {
        return AppProviderImpl(context)
    }

    @Provides
    @Singleton
    fun provideHomeAdapterProviderImpl(): HomeAdapterProvider {
        return HomeAdapterProviderImpl()
    }
}