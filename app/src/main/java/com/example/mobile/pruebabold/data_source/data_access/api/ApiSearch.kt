package com.example.mobile.pruebabold.data_source.data_access.api

import com.example.mobile.pruebabold.data_source.data_access.dto.dto_search.QueryDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSearch {
    @GET("location/search/")
    fun getListSearch(@Query("query") textSearch: String): Call<MutableList<QueryDTO>>
}