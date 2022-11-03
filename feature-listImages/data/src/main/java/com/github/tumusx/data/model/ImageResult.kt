package com.github.tumusx.data.model

data class ImageResult(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)