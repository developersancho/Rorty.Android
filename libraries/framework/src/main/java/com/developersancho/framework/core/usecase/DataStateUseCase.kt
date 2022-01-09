/*
 * Copyright (C) 2022, developersancho
 * All rights reserved.
 */
package com.developersancho.framework.core.usecase

import com.developersancho.framework.core.network.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class DataStateUseCase<in Params, ReturnType> where ReturnType : Any {

    protected abstract suspend fun FlowCollector<DataState<ReturnType>>.execute(params: Params)

    suspend operator fun invoke(params: Params) = flow {
        execute(params)
    }.flowOn(Dispatchers.IO)
}
