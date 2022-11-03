package com.github.tumusx.network

sealed class RequestResult<T> (val dataResult: T? = null, val messageError: String? = null){
    class SuccessRequest<T>(dataResult: T) : RequestResult<T>(dataResult)
    class FailureRequest<T>(dataResult: T? = null, messageError: String?) : RequestResult<T>(dataResult, messageError)
}