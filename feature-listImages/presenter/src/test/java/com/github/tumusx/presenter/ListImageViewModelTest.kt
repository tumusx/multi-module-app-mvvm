package com.github.tumusx.presenter

import com.github.tumusx.basetest.getOrAwaitValueTest
import com.github.tumusx.domain.model.ImageResultVO
import com.github.tumusx.presenter.viewModel.ListImageViewModel
import com.github.tumusx.shared.State
import com.github.tumusx.shared.ValidateSearch
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ListImageViewModelTest {
    private lateinit var useCaseMock: UseCaseMock
    private lateinit var viewModel: ListImageViewModel

    @Before
    fun setup() {
        useCaseMock = UseCaseMock(RepositoryMock())
        viewModel = ListImageViewModel(useCaseMock)
    }

    @Test
    fun `validate search empty`() {
        val result = ValidateSearch.onMaxLengthQuery("")
        assertEquals(result, "Não foi possível buscar. É necessário digitar")
    }

    @Test
    fun `when return resultImage`(){
        viewModel.searchImage("adadaa")
        val result = viewModel.stateReceiverImage.getOrAwaitValueTest()
        val resultVo = result as State.SuccessProcess<*>
        assertEquals((resultVo.dataResult as ImageResultVO).imagesListResult, )
    }
}