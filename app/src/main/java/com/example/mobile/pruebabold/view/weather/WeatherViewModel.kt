package com.example.mobile.pruebabold.view.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.uses_case.search_case.ConsulteForSearchUseCase
import com.example.mobile.pruebabold.uses_case.woeid_case.ConsulteForWoeidUseCase
import com.example.mobile.pruebabold.utlis.showInlog
import javax.inject.Inject

class WeatherViewModel : ViewModel() {

    @Inject
    lateinit var consulteForSearchUseCase: ConsulteForSearchUseCase

    init {
        (App.getContext() as App).getComponentApplication()?.inject(this)
    }

    fun callInfoSearch(string: String){
        consulteForSearchUseCase.invoke(string,
            {
                "OK resivi algo".showInlog("Respuesta")
            },
            {
                "Fallo algo".showInlog("Respuesta")
            })
    }
}