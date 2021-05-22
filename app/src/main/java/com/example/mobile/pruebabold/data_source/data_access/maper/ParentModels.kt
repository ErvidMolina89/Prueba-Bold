package com.example.mobile.pruebabold.data_source.data_access.maper

import com.example.mobile.pruebabold.data_source.data_access.dto.ParentDTO
import com.example.mobile.pruebabold.models.ParentModels

fun ParentModels.fromDTO(parentDTO: ParentDTO): ParentModels {
    return ParentModels().apply {
        latt_long = parentDTO.latt_long
        location_type = parentDTO.location_type
        title = parentDTO.title
        woeid = parentDTO.woeid
    }
}

fun ParentDTO.fromModels(parentModels: ParentModels): ParentDTO {
    return ParentDTO().apply {
        latt_long = parentModels.latt_long
        location_type = parentModels.location_type
        title = parentModels.title
        woeid = parentModels.woeid
    }
}