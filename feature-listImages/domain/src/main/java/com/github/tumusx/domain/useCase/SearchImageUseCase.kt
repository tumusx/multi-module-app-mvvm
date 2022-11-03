package com.github.tumusx.domain.useCase

import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.network.RequestResult
import kotlinx.coroutines.flow.Flow

interface SearchImageUseCase {

    suspend fun searchImageResult(query: String): Flow<RequestResult<ImageResultVO>>
}