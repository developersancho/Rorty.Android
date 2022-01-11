/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.feature.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import com.developersancho.framework.core.adapter.BasicViewHolder
import com.developersancho.rorty.databinding.RowFavoriteBinding
import com.developersancho.rorty.features.favorites.FavoritesAdapter
import com.developersancho.testutils.TestRobolectric
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockkStatic
import org.junit.Assert
import org.junit.Test

class FavoritesAdapterTest : TestRobolectric() {

    @MockK
    lateinit var viewGroup: ViewGroup

    @MockK
    lateinit var layoutInflater: LayoutInflater

    lateinit var viewHolder: BasicViewHolder<*>

    @RelaxedMockK
    lateinit var binding: RowFavoriteBinding

    @MockK(relaxed = true)
    @SpyK
    lateinit var adapter: FavoritesAdapter

    @Test
    fun createBinding_ShouldInitializeCorrectly() {
        // Arrange (Given)
        mockkStatic(RowFavoriteBinding::class)
        every { adapter.createBinding(layoutInflater, viewGroup) } returns binding

        // Act (When)
        viewHolder = BasicViewHolder(binding)

        // Assert (Then)
        Assert.assertEquals(binding, viewHolder.binding)
    }
}