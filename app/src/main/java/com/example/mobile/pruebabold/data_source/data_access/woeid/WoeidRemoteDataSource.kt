package com.example.mobile.pruebabold.data_source.data_access.woeid

import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.data_source.data_access.api.ApiWoeid
import com.example.mobile.pruebabold.data_source.data_access.dto.dto_woeid.WoeidDTO
import com.example.mobile.pruebabold.data_source.data_access.maper.maper_woeid.fromDTO
import com.example.mobile.pruebabold.models.models_woeid.WoeidModels
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

    fun getConsolidatedWeather(sucess: ((WoeidModels)-> Unit), fail: (()-> Unit)){
        apiWoeid.getListWoeid().enqueue(object: Callback<WoeidDTO>{

            override fun onResponse(
                call: Call<WoeidDTO>,
                response: Response<WoeidDTO>
            ) {
                sucess.invoke(
                    WoeidModels()
                        .fromDTO(response.body()!!))
            }

            override fun onFailure(call: Call<WoeidDTO>, t: Throwable) {
                fail.invoke()
                "fail: getWoeid".showInlog(tag = "WoeidDataSource", t = t)
            }

        })
    }
}