package com.github.tumusx.domain.model

data class ImageResultVO(
    var imagesListResult: List<String>? = emptyList(),
    var totalLikeImage: List<Int>? = emptyList()
)