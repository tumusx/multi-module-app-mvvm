package com.github.tumusx.feature_listimages.di

import com.github.tumusx.data.service.PixBayService
import com.github.tumusx.network.InstanceRetrofit
import org.koin.dsl.module

val listImageModule = module {

    factory { InstanceRetrofit.instanceRetrofit.create(PixBayService::class.java) }
}