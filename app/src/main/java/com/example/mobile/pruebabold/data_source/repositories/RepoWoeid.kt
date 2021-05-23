package com.example.mobile.pruebabold.data_source.repositories

import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.data_source.data_access.woeid.WoeidRemoteDataSource
import com.example.mobile.pruebabold.models.models_woeid.WoeidModels
import javax.inject.Inject

class RepoWoeid {

    @Inject
    lateinit var woeidRemoteDataSource: WoeidRemoteDataSource

    init {
        (App.getContext() as App).getComponentApplication()?.inject(this)
    }

    fun consulteWeather(int: Int, sucess: ((WoeidModels)-> Unit), fail: (()-> Unit)){
        woeidRemoteDataSource.getConsolidatedWeather(sucess, fail)
    }

}