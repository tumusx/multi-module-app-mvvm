package com.github.tumusx.presenter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.tumusx.basetest.MainCoroutineRule
import com.github.tumusx.basetest.getOrAwaitValueTest
import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.presenter.viewModel.ListImageViewModel
import com.github.tumusx.shared.State
import com.github.tumusx.shared.ValidateSearch
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ListImageViewModelTest {
    private lateinit var useCaseMock: UseCaseMock
    private lateinit var viewModel: ListImageViewModel

    @get: Rule
    val instantExecution = InstantTaskExecutorRule()

    @get:Rule
    val coroutineContextRule = MainCoroutineRule()

    @Before
    fun setup() {
        useCaseMock = UseCaseMock(RepositoryMock())
        viewModel = ListImageViewModel(coroutineContextRule.coroutineContext, useCaseMock)
    }

    @Test
    fun `validate util search empty`() {
        val result = ValidateSearch.onMaxLengthQuery("")
        assertEquals(result, "Não foi possível buscar. É necessário digitar")
    }

    @Test
    fun `when call searchImage empty search return error`() {
        viewModel.searchImage("")
        viewModel.stateReceiverImage.getOrAwaitValueTest().also { state ->
            assertEquals(
                "Não foi possível buscar. É necessário digitar",
                (state as State.ErrorProcess).error
            )
        }
    }

    @Test
    fun `when call searchImage return success`() {
        viewModel.searchImage("testando")
        viewModel.stateReceiverImage.getOrAwaitValueTest().also {
            val resultState = when (it) {
                is State.SuccessProcess<*> -> {
                    it.dataResult
                }
                else -> {
                    "ERROR"
                }
            }
            assertEquals(ImageResultVO(), resultState)
        }
    }
}