package com.github.tumusx.data.repository

import com.github.tumusx.data.service.PixBayService
import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.domain.repository.PixBayRepository
import com.github.tumusx.network.RequestResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PixBayRepositoryImpl(private val pixbayService: PixBayService) : PixBayRepository {
    override suspend fun getImageResult(queryImage: String): Flow<RequestResult<ImageResultVO>> =
        flow {
            val searchImageResult = pixbayService.searchImage(searchQuery = queryImage)
            try {
                if (searchImageResult.isSuccessful) {
                    val imageResultVO = ImageResultVO()
                    searchImageResult.body()?.hits?.forEach { resultImage ->
                        imageResultVO.imageUrl?.add(resultImage.previewURL)
                        imageResultVO.nameImage?.add(resultImage.id.toString())
                    }
                    emit(RequestResult.SuccessRequest(imageResultVO))
                } else {
                    emit(RequestResult.FailureRequest(null, searchImageResult.message()))
                }
            } catch (exception: Exception) {
                emit(
                    RequestResult.FailureRequest(
                        null,
                        "Aconteceu algum erro ao processar sua requisão"
                    )
                )
                exception.printStackTrace()
            }
        }

}