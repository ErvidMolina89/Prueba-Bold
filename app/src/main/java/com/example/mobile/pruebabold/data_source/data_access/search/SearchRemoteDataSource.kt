package com.example.mobile.pruebabold.data_source.data_access.search

import com.example.mobile.pruebabold.R
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.data_source.data_access.api.ApiSearch
import com.example.mobile.pruebabold.data_source.data_access.dto.dto_search.QueryDTO
import com.example.mobile.pruebabold.data_source.data_access.maper.maper_search.fromDTO
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.utlis.DialogGeneric
import com.example.mobile.pruebabold.utlis.showDialogGeneric
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

    fun getSearchWeather(search: String, sucess: ((MutableList<QueryModels>)-> Unit), fail: (()-> Unit)){
        apiSearch.getListSearch(search).enqueue(object: Callback<MutableList<QueryDTO>>{

            override fun onResponse(
                call: Call<MutableList<QueryDTO>>,
                response: Response<MutableList<QueryDTO>>
            ) {
                if(response.body() != null){
                    sucess.invoke(
                    response.body()!!.map { it ->
                        return@map QueryModels().fromDTO(it)
                    }.toMutableList()
                    )
                }else{

                }
            }

            override fun onFailure(call: Call<MutableList<QueryDTO>>, t: Throwable) {
                fail.invoke()
                "fail: getQuery".showInlog(tag = "SearchDataSource", t = t)
            }

        })
    }
}