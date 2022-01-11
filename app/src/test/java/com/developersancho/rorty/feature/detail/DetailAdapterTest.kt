/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.feature.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developersancho.framework.core.adapter.BasicViewHolder
import com.developersancho.rorty.databinding.RowDetailBinding
import com.developersancho.rorty.features.detail.DetailAdapter
import com.developersancho.testutils.TestRobolectric
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockkStatic
import org.junit.Assert
import org.junit.Test

class DetailAdapterTest : TestRobolectric() {

    @MockK
    lateinit var view: View

    @MockK
    lateinit var viewGroup: ViewGroup

    @MockK
    lateinit var layoutInflater: LayoutInflater

    lateinit var viewHolder: BasicViewHolder<*>

    @MockK(relaxed = true)
    lateinit var binding: RowDetailBinding

    @MockK(relaxed = true)
    @SpyK
    lateinit var adapter: DetailAdapter

    @Test
    fun createBinding_ShouldInitializeCorrectly() {
        // Arrange (Given)
        mockkStatic(RowDetailBinding::class)
        every { adapter.createBinding(layoutInflater, viewGroup) } returns binding

        // Act (When)
        viewHolder = BasicViewHolder(binding)

        // Assert (Then)
        Assert.assertEquals(binding, viewHolder.binding)
    }

    /*@Test
    fun bindView() {
        // Arrange (Given)
        mockkStatic(RowDetailBinding::class)
        val item = mockk<KeyValueModel>(relaxed = true)
        val position = mockk<Int>(relaxed = true)
        every { RowDetailBinding.inflate(context.inflater, viewGroup, false) } returns binding

        // Act (When)
        viewHolder = BasicViewHolder(binding)
        adapter.bindView(binding, position, item)

        // Assert (Then)
        Assert.assertSame(adapter.getItem(position).cast(), item)
    }*/
}