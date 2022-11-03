package com.github.tumusx.shoppinglistitems

import android.app.Application
import com.github.tumusx.feature_listimages.di.listImageModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppInit: Application() {
    override fun onCreate() {
        startKoin {
            androidContext(this@AppInit)
            modules(listImageModule)
        }
        super.onCreate()
    }
}