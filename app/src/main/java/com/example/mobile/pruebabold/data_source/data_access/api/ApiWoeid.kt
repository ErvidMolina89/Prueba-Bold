package com.example.mobile.pruebabold.data_source.data_access.api

import com.example.mobile.pruebabold.data_source.data_access.dto.ConsolidatedWeatherDTO
import retrofit2.Call
import retrofit2.http.GET

interface ApiWoeid {
    @GET("location/44418")
    fun getListWoeid(): Call<ConsolidatedWeatherDTO>
}