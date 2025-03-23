package com.sportscan

import android.app.Application
import com.sportscan.domain.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}