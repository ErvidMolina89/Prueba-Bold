package com.example.mobile.pruebabold.data_source.repositories

import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.data_source.data_access.search.SearchRemoteDataSource
import com.example.mobile.pruebabold.models.models_search.QueryModels
import javax.inject.Inject

class RepoSearch {

    @Inject
    lateinit var searchRemoteDataSource: SearchRemoteDataSource

    init {
        (App.getContext() as App).getComponentApplication()?.inject(this)
    }

    fun consulteSearchQuery(string: String, sucess: ((MutableList<QueryModels>)-> Unit), fail: (()-> Unit)){
        searchRemoteDataSource.getSearchWeather(sucess, fail)
    }

}