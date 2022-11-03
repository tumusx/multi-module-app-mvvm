package com.github.tumusx.feature_listimages.di

import com.github.tumusx.data.repository.PixBayRepositoryImpl
import com.github.tumusx.data.service.PixBayService
import com.github.tumusx.network.InstanceRetrofit
import com.github.tumusx.presenter.viewModel.ListImageViewModel
import org.koin.dsl.module

val listImageModule = module {

    fun providerInstanceRetrofit(): PixBayService {
        return InstanceRetrofit.instanceRetrofit.create(PixBayService::class.java)
    }


    fun providerRepository(): PixBayRepositoryImpl {
        return PixBayRepositoryImpl(providerInstanceRetrofit())
    }

    factory { ListImageViewModel(providerRepository()) }
}