/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.local.di

import android.content.Context
import com.developersancho.local.BuildConfig
import com.developersancho.local.dao.FavoriteDao
import com.developersancho.local.db.RortyDatabase
import com.developersancho.testutils.MockkUnitTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class LocalModuleTest: MockkUnitTest() {

    private lateinit var localModule: LocalModule

    override fun onCreate() {
        super.onCreate()
        localModule = LocalModule()
    }

    @Test
    fun verifyProvideDatabaseName() {
        val databaseName = localModule.provideDatabaseName()
        assertEquals(databaseName, BuildConfig.DB_NAME)
    }

    @Test
    fun verifyProvideAppDatabase() {
        val context: Context = mockk()
        val databaseName = localModule.provideDatabaseName()
        val database = localModule.provideDatabase(databaseName, context)

        Assert.assertNotNull(database.favoriteDao())
    }

    @Test
    fun verifyProvideFavoriteDao() {
        val database: RortyDatabase = mockk()
        val favoriteDao: FavoriteDao = mockk()

        every { database.favoriteDao() } returns favoriteDao

        assertEquals(
            favoriteDao,
            localModule.provideFavoriteDao(database)
        )
        verify { database.favoriteDao() }
    }
}