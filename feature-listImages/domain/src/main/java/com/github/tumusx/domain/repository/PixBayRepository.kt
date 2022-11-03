package com.github.tumusx.domain.repository

import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.network.RequestResult
import kotlinx.coroutines.flow.Flow

interface PixBayRepository {
    suspend fun getImageResult(queryImage: String): Flow<RequestResult<ImageResultVO>>
}