/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.domain.di

import android.annotation.SuppressLint
import com.developersancho.domain.usecase.character.GetCharacterDetail
import com.developersancho.domain.usecase.character.GetCharacters
import com.developersancho.domain.usecase.favorite.AddFavorite
import com.developersancho.domain.usecase.favorite.DeleteFavorite
import com.developersancho.domain.usecase.favorite.GetFavorites
import com.developersancho.domain.usecase.favorite.UpdateFavorite
import com.developersancho.repository.character.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressLint("VisibleForTests")
@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Singleton
    @Provides
    fun provideGetCharacters(repository: CharacterRepository) = GetCharacters(repository)

    @Singleton
    @Provides
    fun provideGetCharacterDetail(repository: CharacterRepository) = GetCharacterDetail(repository)

    @Singleton
    @Provides
    fun provideGetFavorites(repository: CharacterRepository) = GetFavorites(repository)

    @Singleton
    @Provides
    fun provideAddFavorite(repository: CharacterRepository) = AddFavorite(repository)

    @Singleton
    @Provides
    fun provideDeleteFavorite(repository: CharacterRepository) = DeleteFavorite(repository)

    @Singleton
    @Provides
    fun provideUpdateFavorite(repository: CharacterRepository) = UpdateFavorite(repository)
}
