package com.example.eurogas.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GasStationApiConfig {
    companion object {
        private const val BASE_URL = "https://sedeaplicaciones.minetur.gob.es/"

        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}