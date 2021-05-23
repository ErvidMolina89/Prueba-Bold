package com.example.mobile.pruebabold.data_source.data_access.api

import com.example.mobile.pruebabold.data_source.data_access.dto.dto_search.QueryDTO
import com.example.mobile.pruebabold.data_source.data_access.dto.dto_woeid.WoeidDTO
import retrofit2.Call
import retrofit2.http.GET

interface ApiSearch {
    @GET("location/search/?query=san")
    fun getListSearch(): Call<MutableList<QueryDTO>>
}