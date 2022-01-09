/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KeyValueModel(
    val key: String?,
    val value: String?
) : Parcelable
