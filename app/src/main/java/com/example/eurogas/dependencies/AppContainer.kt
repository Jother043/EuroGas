package com.example.eurogas.dependencies

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.example.eurogas.api.ApiService
import com.example.eurogas.api.GasStationApiConfig
import com.example.eurogas.repositories.GasStationRepository

class AppContainer(context: Context) {

    private val GasStationApiService = GasStationApiConfig.provideRetrofit().create(ApiService::class.java)

    val GasStationRepository: GasStationRepository = GasStationRepository(GasStationApiService)

}