package com.github.tumusx.data.service

import com.github.tumusx.data.model.ImageResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixBayService {
    @GET("/api/")
    suspend fun searchImage(@Query("key") key: String = "31042039-8c71b528290e71e87efbfcab4",
                            @Query("q") searchQuery: String) : Response<ImageResult>
}