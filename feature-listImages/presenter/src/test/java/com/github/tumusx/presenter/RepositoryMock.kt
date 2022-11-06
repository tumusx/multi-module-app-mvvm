package com.github.tumusx.presenter

import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.domain.repository.PixBayRepository
import com.github.tumusx.network.RequestResult
import com.github.tumusx.shared.ValidateSearch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryMock : PixBayRepository {
    override suspend fun getImageResult(queryImage: String): Flow<RequestResult<ImageResultVO>> =
        flow {

            emit(RequestResult.SuccessRequest(ImageResultVO(listOf(), listOf())))
        }
}