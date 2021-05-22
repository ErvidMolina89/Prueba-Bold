package com.example.mobile.pruebabold.data_source.data_access.woeid

import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.data_source.data_access.api.ApiWoeid
import com.example.mobile.pruebabold.data_source.data_access.dto.ConsolidatedWeatherDTO
import com.example.mobile.pruebabold.data_source.data_access.maper.fromDTO
import com.example.mobile.pruebabold.models.ConsolidatedWeatherModels
import com.example.mobile.pruebabold.utlis.showInlog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WoeidRemoteDataSource {

    @Inject lateinit var apiWoeid: ApiWoeid

    init {
        (App.getContext() as App)
            .getComponentApplication()
            ?.inject(this)
    }

    fun getConsolidatedWeather(sucess: ((ConsolidatedWeatherModels)-> Unit), fail: (()-> Unit)){
        apiWoeid.getListWoeid().enqueue(object: Callback<ConsolidatedWeatherDTO>{

            override fun onResponse(
                call: Call<ConsolidatedWeatherDTO>,
                response: Response<ConsolidatedWeatherDTO>
            ) {
                sucess.invoke(ConsolidatedWeatherModels().fromDTO(response.body()!!))
            }

            override fun onFailure(call: Call<ConsolidatedWeatherDTO>, t: Throwable) {
                fail.invoke()
                "fail: getConsolidatedWeather".showInlog(tag = "WoeidDataSource", t = t)
            }

        })
    }
}