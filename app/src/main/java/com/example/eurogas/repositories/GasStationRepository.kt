package com.example.eurogas.repositories

import com.example.eurogas.api.ApiService

class GasStationRepository(
    val GasStationApi: ApiService
) {

    suspend fun getGasStations() = GasStationApi.getGasStations()
}