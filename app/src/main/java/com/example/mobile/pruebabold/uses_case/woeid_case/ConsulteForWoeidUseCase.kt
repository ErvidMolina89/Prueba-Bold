package com.example.mobile.pruebabold.uses_case.woeid_case

import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.data_source.repositories.RepoWoeid
import com.example.mobile.pruebabold.models.models_woeid.WoeidModels
import javax.inject.Inject

class ConsulteForWoeidUseCase {

    @Inject
    lateinit var repoWoeid: RepoWoeid

    init {
        (App.getContext() as App).getComponentApplication()?.inject(this)
    }

    fun invoke(woeid: Int, sucess: ((WoeidModels)-> Unit), fail: (()-> Unit)) {
        repoWoeid.consulteWeather(woeid, sucess, fail)
    }

}