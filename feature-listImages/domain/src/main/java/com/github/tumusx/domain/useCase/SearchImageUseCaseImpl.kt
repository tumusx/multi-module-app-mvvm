package com.github.tumusx.domain.useCase

import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.domain.repository.PixBayRepository
import com.github.tumusx.network.RequestResult
import com.github.tumusx.shared.ValidateSearch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchImageUseCaseImpl(private val repository: PixBayRepository) : SearchImageUseCase {

    override suspend fun searchImageResult(query: String): Flow<RequestResult<ImageResultVO>> =
        flow {
            try {
                if (ValidateSearch.onMaxLengthQuery(query).isNotEmpty()) {
                    emit(RequestResult.FailureRequest(null, ValidateSearch.error))
                } else {
                    repository.getImageResult(query).collect { resultImage ->
                        resultImage.dataResult?.let { results ->
                            emit(RequestResult.SuccessRequest(results))
                        }
                    }
                }

            } catch (exception: Exception) {
                exception.printStackTrace()
                emit(RequestResult.FailureRequest(null, "Aconteceu um erro Desconhecido"))
            }
        }
}