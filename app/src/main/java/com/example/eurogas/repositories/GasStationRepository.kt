package com.example.eurogas.repositories

import GasStationsResponse
import android.util.Log
import com.example.eurogas.api.ApiService
import retrofit2.Response
import android.accounts.NetworkErrorException

class GasStationRepository(
    val GasStationApi: ApiService
) {

    suspend fun getGasStations() : Response<GasStationsResponse> {
        GasStationApi.getGasStations().toString()
        Log.d("GasStationRepository", GasStationApi.getGasStations().toString())
        return GasStationApi.getGasStations()
    }
}