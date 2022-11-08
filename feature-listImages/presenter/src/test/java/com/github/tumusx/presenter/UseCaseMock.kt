package com.github.tumusx.presenter

import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.domain.useCase.SearchImageUseCase
import com.github.tumusx.network.RequestResult
import com.github.tumusx.shared.ValidateSearch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UseCaseMock(private val repositoryMock: RepositoryMock) : SearchImageUseCase {
    override suspend fun searchImageResult(query: String): Flow<RequestResult<ImageResultVO>> =
        flow {
            if (ValidateSearch.onMaxLengthQuery(query)?.isNotEmpty() == true) {
                emit(RequestResult.FailureRequest(null, "Não foi possível buscar. É necessário digitar"))
            } else {
                repositoryMock.getImageResult(query).collect {
                    emit(RequestResult.SuccessRequest(ImageResultVO(listOf(), listOf())))
                }
            }
        }
}