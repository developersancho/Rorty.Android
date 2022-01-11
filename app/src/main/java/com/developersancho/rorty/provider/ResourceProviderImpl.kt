/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.rorty.provider

import android.content.Context

class ResourceProviderImpl(private val context: Context) : ResourceProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }
}