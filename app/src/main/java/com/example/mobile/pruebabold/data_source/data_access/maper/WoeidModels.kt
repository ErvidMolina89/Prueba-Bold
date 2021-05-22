package com.example.mobile.pruebabold.data_source.data_access.maper

import com.example.mobile.pruebabold.data_source.data_access.dto.WoeidDTO
import com.example.mobile.pruebabold.models.WoeidModels

fun WoeidModels.fromDTO(woeidDTO: WoeidDTO): WoeidModels {
    return WoeidModels().apply {
        latt_long = woeidDTO.latt_long
        location_type = woeidDTO.location_type
        title = woeidDTO.title
        woeid = woeidDTO.woeid
    }
}

fun WoeidDTO.fromModels(woeidModels: WoeidModels): WoeidDTO {
    return WoeidDTO().apply {
        latt_long = woeidModels.latt_long
        location_type = woeidModels.location_type
        title = woeidModels.title
        woeid = woeidModels.woeid
    }
}