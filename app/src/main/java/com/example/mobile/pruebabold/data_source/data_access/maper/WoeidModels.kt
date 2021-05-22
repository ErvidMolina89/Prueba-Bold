package com.example.mobile.pruebabold.data_source.data_access.maper

import com.example.mobile.pruebabold.data_source.data_access.dto.ConsolidatedWeatherDTO
import com.example.mobile.pruebabold.data_source.data_access.dto.ParentDTO
import com.example.mobile.pruebabold.data_source.data_access.dto.SourceDTO
import com.example.mobile.pruebabold.data_source.data_access.dto.WoeidDTO
import com.example.mobile.pruebabold.models.ConsolidatedWeatherModels
import com.example.mobile.pruebabold.models.ParentModels
import com.example.mobile.pruebabold.models.SourceModels
import com.example.mobile.pruebabold.models.WoeidModels

fun WoeidModels.fromDTO(woeidDTO: WoeidDTO): WoeidModels {
    return WoeidModels().apply {
        consolidated_weather = woeidDTO.consolidated_weather?.map {
                it -> return@map ConsolidatedWeatherModels().fromDTO(it)
        }?.toMutableList()
        latt_long = woeidDTO.latt_long
        location_type = woeidDTO.location_type
        if(woeidDTO.parent != null){
            parent = ParentModels().fromDTO(woeidDTO.parent!!)
        }
        sources = woeidDTO.sources?.map {
                it -> return@map SourceModels().fromDTO(it)
        }?.toMutableList()
        sun_rise = woeidDTO.sun_rise
        sun_set = woeidDTO.sun_set
        time = woeidDTO.time
        timezone = woeidDTO.timezone
        timezone_name = woeidDTO.timezone_name
        title = woeidDTO.title
        woeid = woeidDTO.woeid
    }
}

fun WoeidDTO.fromModels(woeidModels: WoeidModels): WoeidDTO {
    return WoeidDTO().apply {
        consolidated_weather = woeidModels.consolidated_weather?.map {
                it -> return@map ConsolidatedWeatherDTO().fromModels(it)
        }?.toMutableList()
        latt_long = woeidModels.latt_long
        location_type = woeidModels.location_type
        if(woeidModels.parent != null){
            parent = ParentDTO().fromModels(woeidModels.parent!!)
        }
        sources = woeidModels.sources?.map {
                it -> return@map SourceDTO().fromModels(it)
        }?.toMutableList()
        sun_rise = woeidModels.sun_rise
        sun_set = woeidModels.sun_set
        time = woeidModels.time
        timezone = woeidModels.timezone
        timezone_name = woeidModels.timezone_name
        title = woeidModels.title
        woeid = woeidModels.woeid
    }
}