package com.example.mobile.pruebabold.data_source.data_access.api

import com.example.mobile.pruebabold.data_source.data_access.dto.dto_woeid.WoeidDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiWoeid {
    @GET("location/{woeid}")
    fun getListWoeid(@Path("woeid") woeid: Int): Call<WoeidDTO>
}