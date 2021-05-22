package com.example.mobile.pruebabold.view.woeid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.uses_case.woeid_case.ConsulteForWoeidUseCase
import com.example.mobile.pruebabold.utlis.showInlog
import javax.inject.Inject

class WoeidViewModel : ViewModel() {

    @Inject
    lateinit var consulteForWoeidUseCase: ConsulteForWoeidUseCase

    init {
        (App.getContext() as App).getComponentApplication()?.inject(this)
    }

    fun callInfoWoeid(){
        consulteForWoeidUseCase.invoke(15,
            {
                "OK resivi algo".showInlog("Respuesta")
            },
            {
                "Fallo algo".showInlog("Respuesta")
            })
    }
}