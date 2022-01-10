/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.domain.di

import com.developersancho.repository.character.CharacterRepository
import com.developersancho.testutils.MockkUnitTest
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class DomainModuleTest : MockkUnitTest() {

    private lateinit var module: DomainModule

    override fun onCreate() {
        super.onCreate()
        module = DomainModule()
    }

    @Test
    fun verifyProvideGetCharacters() {
        val repository = mockk<CharacterRepository>()
        val getCharacterList = module.provideGetCharacters(repository)

        Assert.assertEquals(repository, getCharacterList.repository)
    }

    @Test
    fun verifyProvideGetCharacterDetail() {
        val repository = mockk<CharacterRepository>()
        val getCharacterDetail = module.provideGetCharacterDetail(repository)

        Assert.assertEquals(repository, getCharacterDetail.repository)
    }

    @Test
    fun verifyProvideGetFavorites() {
        val repository = mockk<CharacterRepository>()
        val getFavoriteList = module.provideGetFavorites(repository)

        Assert.assertEquals(repository, getFavoriteList.repository)
    }

    @Test
    fun verifyProvideAddFavorite() {
        val repository = mockk<CharacterRepository>()
        val addFavorite = module.provideAddFavorite(repository)

        Assert.assertEquals(repository, addFavorite.repository)
    }

    @Test
    fun verifyProvideDeleteFavorite() {
        val repository = mockk<CharacterRepository>()
        val deleteFavorite = module.provideDeleteFavorite(repository)

        Assert.assertEquals(repository, deleteFavorite.repository)
    }

    @Test
    fun verifyProvideUpdateFavorite() {
        val repository = mockk<CharacterRepository>()
        val updateFavorite = module.provideUpdateFavorite(repository)

        Assert.assertEquals(repository, updateFavorite.repository)
    }
}