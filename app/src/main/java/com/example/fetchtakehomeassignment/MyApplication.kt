package com.example.fetchtakehomeassignment

import android.app.Application
import com.example.fetchtakehomeassignment.data.di.dataModule
import com.example.fetchtakehomeassignment.ui.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(dataModule, presentationModule)
        }
    }
}