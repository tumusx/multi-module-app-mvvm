package com.github.tumusx.presenter.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.domain.useCase.SearchImageUseCase
import com.github.tumusx.network.RequestResult
import com.github.tumusx.shared.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListImageViewModel(private val searchImageUseCase: SearchImageUseCase) : ViewModel() {
    private val _stateReceiverImage: MutableLiveData<State> =
        MutableLiveData(State.LoadingProcess)
    val stateReceiverImage: LiveData<State> = _stateReceiverImage

    fun searchImage(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            searchImageUseCase.searchImageResult(query).collect {
                when (it) {
                    is RequestResult.SuccessRequest<ImageResultVO> -> {
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
}