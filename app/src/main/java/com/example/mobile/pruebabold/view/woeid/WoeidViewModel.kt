package com.example.mobile.pruebabold.view.woeid

import androidx.lifecycle.ViewModel
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.models.models_woeid.WoeidModels
import com.example.mobile.pruebabold.uses_case.woeid_case.ConsulteForWoeidUseCase
import com.example.mobile.pruebabold.utlis.showInlog
import com.example.mobile.pruebabold.view.weather.SearchViewModelDelegate
import javax.inject.Inject

interface WoeidViewModelDelegate {
    fun setMediaQuery(woeidModels: WoeidModels)
    fun setFailDataLoad()
}
class WoeidViewModel : ViewModel() {

    @Inject
    lateinit var consulteForWoeidUseCase: ConsulteForWoeidUseCase
    private var delegate: WoeidViewModelDelegate? = null

    init {
        (App.getContext() as App).getComponentApplication()?.inject(this)
    }

    fun callInfoWoeid(woeid: Int){
        consulteForWoeidUseCase.invoke(woeid,
            {
                delegate?.setMediaQuery(it)
            },
            {
                delegate?.setFailDataLoad()
                "Fallo algo".showInlog("Respuesta")
            })
    }

    fun setDelegate(delegate: WoeidViewModelDelegate){
        this.delegate = delegate
    }
}