package com.github.tumusx.data.repository

import android.util.Log
import com.github.tumusx.data.model.ImageResult
import com.github.tumusx.data.service.PixBayService
import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.network.RequestResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PixBayRepositoryImpl(private val pixbayService: PixBayService) {
    suspend fun getImageResult(queryImage: String): Flow<RequestResult<ImageResult>> =
        flow {
            val searchImageResult = pixbayService.searchImage(searchQuery = queryImage)
            try {
                if (searchImageResult.isSuccessful) {
                    val imageResultVO = ImageResultVO()
                    searchImageResult.body()?.let { imageResultSearch ->
                        imageResultSearch.hits.map { resultImage ->
                            imageResultVO.imageUrl?.add(resultImage.previewURL)
                            imageResultVO.nameImage?.add(resultImage.id.toString())
                        }
                        Log.d("TESTE", imageResultSearch.toString())
                        emit(RequestResult.SuccessRequest(imageResultSearch))
                    }
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