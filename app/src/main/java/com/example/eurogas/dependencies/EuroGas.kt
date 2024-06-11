package com.example.eurogas.dependencies

import android.app.Application

class EuroGas : Application() {

    private lateinit var _appContainer: AppContainer
    val appContainer get() = _appContainer

    override fun onCreate() {
        super.onCreate()
        _appContainer = AppContainer(this)
    }
}