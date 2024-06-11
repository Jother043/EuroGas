package com.example.eurogas.api

import GasStationsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/")
        suspend fun getGasStations(): Response<GasStationsResponse>
}