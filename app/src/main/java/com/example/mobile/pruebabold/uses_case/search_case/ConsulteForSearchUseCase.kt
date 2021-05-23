package com.example.mobile.pruebabold.uses_case.search_case

import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.data_source.repositories.RepoSearch
import com.example.mobile.pruebabold.data_source.repositories.RepoWoeid
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.models.models_woeid.WoeidModels
import javax.inject.Inject

class ConsulteForSearchUseCase {

    @Inject
    lateinit var repoSearch: RepoSearch

    init {
        (App.getContext() as App).getComponentApplication()?.inject(this)
    }

    fun invoke(string: String, sucess: ((MutableList<QueryModels>)-> Unit), fail: (()-> Unit)) {
        repoSearch.consulteSearchQuery(string, sucess, fail)
    }

}