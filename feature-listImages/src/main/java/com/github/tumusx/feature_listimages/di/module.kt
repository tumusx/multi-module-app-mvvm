package com.github.tumusx.feature_listimages.di

import com.github.tumusx.data.repository.PixBayRepositoryImpl
import com.github.tumusx.data.service.PixBayService
import com.github.tumusx.domain.useCase.SearchImageUseCase
import com.github.tumusx.domain.useCase.SearchImageUseCaseImpl
import com.github.tumusx.network.InstanceRetrofit
import com.github.tumusx.presenter.viewModel.ListImageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val listImageModule = module {

    fun providerInstanceRetrofit(): PixBayService {
        return InstanceRetrofit.instanceRetrofit.create(PixBayService::class.java)
    }

    fun providerRepository(): PixBayRepositoryImpl {
        return PixBayRepositoryImpl(providerInstanceRetrofit())
    }

    fun providerInstanceSearchUseCase(): SearchImageUseCase {
        return SearchImageUseCaseImpl(providerRepository())
    }

    viewModel { ListImageViewModel(providerInstanceSearchUseCase()) }
}