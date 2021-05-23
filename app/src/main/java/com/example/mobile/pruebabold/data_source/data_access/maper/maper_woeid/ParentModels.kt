package com.example.mobile.pruebabold.data_source.data_access.maper.maper_woeid

import com.example.mobile.pruebabold.data_source.data_access.dto.dto_woeid.ParentDTO
import com.example.mobile.pruebabold.models.models_woeid.ParentModels

fun ParentModels.fromDTO(parentDTO: ParentDTO): ParentModels {
    return ParentModels().apply {
        latt_long = parentDTO.latt_long
        location_type = parentDTO.location_type
        title = parentDTO.title
        woeid = parentDTO.woeid
    }
}

fun ParentDTO.fromModels(parentModels: ParentModels): ParentDTO {
    return ParentDTO()
        .apply {
        latt_long = parentModels.latt_long
        location_type = parentModels.location_type
        title = parentModels.title
        woeid = parentModels.woeid
    }
}