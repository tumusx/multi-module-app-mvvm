package com.github.tumusx.shared

sealed class State {
    data class SuccessProcess<T>(var dataResult: T) : State()
    data class ErrorProcess(var error: String? = null) : State()
    object LoadingProcess: State()
}