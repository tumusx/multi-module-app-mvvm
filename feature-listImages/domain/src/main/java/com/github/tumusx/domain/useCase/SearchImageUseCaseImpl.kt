package com.github.tumusx.domain.useCase

import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.domain.repository.PixBayRepository
import com.github.tumusx.network.RequestResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchImageUseCaseImpl(private val repository: PixBayRepository) : SearchImageUseCase {

    override suspend fun searchImageResult(query: String): Flow<RequestResult<ImageResultVO>> =
        flow {
            try {
                if (query.isEmpty()) {
                    emit(RequestResult.FailureRequest(null, "Não foi possível buscar. É necessário digitar"))
                }

                if (query.count() > 20) {
                }

            } catch (exception: Exception) {
                exception.printStackTrace()
                emit(RequestResult.FailureRequest(null, "Aconteceu um erro Desconhecido"))
            }
        }
}