package com.github.tumusx.presenter.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.data.model.ImageResult
import com.github.tumusx.data.repository.PixBayRepositoryImpl
import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.domain.repository.PixBayRepository
import com.github.tumusx.network.RequestResult
import com.github.tumusx.shared.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ListImageViewModel(private val pixBayRepository: PixBayRepositoryImpl) : ViewModel() {
    private val _stateReceiverImage: MutableStateFlow<State> =
        MutableStateFlow(State.LoadingProcess)
    val stateReceiverImage: StateFlow<State> = _stateReceiverImage

    fun searchImage(query: String) = viewModelScope.launch(Dispatchers.IO) {
        pixBayRepository.getImageResult(query).collect {
            when (it) {
                is RequestResult.SuccessRequest<ImageResult> -> {
                    Log.d("SCCESS", it.dataResult.toString())
                    _stateReceiverImage.value = State.SuccessProcess(it.dataResult)
                }

                is RequestResult.FailureRequest -> {
                    _stateReceiverImage.value = State.ErrorProcess(it.messageError)
                    Log.d("RESULT DATA ERROR ", it.messageError.toString())
                }
            }
        }
    }
}