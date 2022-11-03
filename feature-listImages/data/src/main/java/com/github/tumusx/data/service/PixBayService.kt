package com.github.tumusx.data.service

import com.github.tumusx.data.BuildConfig
import com.github.tumusx.data.model.ImageResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixBayService {
    @GET("/api/")
    suspend fun searchImage(@Query("key") key: String = BuildConfig.API_KEY,
                            @Query("q") searchQuery: String) : Response<ImageResult>
}