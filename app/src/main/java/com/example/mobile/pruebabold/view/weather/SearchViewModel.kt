package com.example.mobile.pruebabold.view.weather

import androidx.lifecycle.ViewModel
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.uses_case.search_case.ConsulteForSearchUseCase
import com.example.mobile.pruebabold.utlis.showInlog
import javax.inject.Inject

interface SearchViewModelDelegate {
    fun setMediaQuery(list: MutableList<QueryModels>)
    fun setFailDataLoad()
    fun navigationToLocation(location: QueryModels)
}

class SearchViewModel : ViewModel() {

    @Inject
    lateinit var consulteForSearchUseCase: ConsulteForSearchUseCase
    private var delegate: SearchViewModelDelegate? = null

    init {
        (App.getContext() as App).getComponentApplication()?.inject(this)
    }

    fun callInfoSearch(search: String){
        consulteForSearchUseCase.invoke(search,
            {
                delegate?.setMediaQuery(it)
            },
            {
                delegate?.setFailDataLoad()
                "Fallo algo".showInlog("Respuesta")
            })
    }

    fun setDelegate(delegate: SearchViewModelDelegate){
        this.delegate = delegate
    }

    fun showDetailsItemSelect(location: QueryModels){
        delegate?.navigationToLocation(location)
    }
}