package com.example.mobile.pruebabold.data_source.data_access.search

import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.data_source.data_access.api.ApiSearch
import com.example.mobile.pruebabold.data_source.data_access.dto.dto_search.QueryDTO
import com.example.mobile.pruebabold.data_source.data_access.maper.maper_search.fromDTO
import com.example.mobile.pruebabold.data_source.data_access.maper.maper_search.fromModels
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.utlis.showInlog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class SearchRemoteDataSource {

    @Inject lateinit var apiSearch: ApiSearch

    init {
        (App.getContext() as App)
            .getComponentApplication()
            ?.inject(this)
    }

    fun getSearchWeather(sucess: ((MutableList<QueryModels>)-> Unit), fail: (()-> Unit)){
        apiSearch.getListSearch().enqueue(object: Callback<MutableList<QueryDTO>>{

            override fun onResponse(
                call: Call<MutableList<QueryDTO>>,
                response: Response<MutableList<QueryDTO>>
            ) {
                sucess.invoke(
                        response.body()!!.map { it ->
                            return@map QueryModels().fromDTO(it)
                        }.toMutableList())
            }

            override fun onFailure(call: Call<MutableList<QueryDTO>>, t: Throwable) {
                fail.invoke()
                "fail: getQuery".showInlog(tag = "SearchDataSource", t = t)
            }

        })
    }
}