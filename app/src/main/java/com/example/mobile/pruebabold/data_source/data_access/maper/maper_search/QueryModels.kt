package com.example.mobile.pruebabold.data_source.data_access.maper.maper_search

import com.example.mobile.pruebabold.data_source.data_access.dto.dto_search.QueryDTO
import com.example.mobile.pruebabold.models.models_search.QueryModels

fun QueryModels.fromDTO(queryDTO: QueryDTO): QueryModels {
    return QueryModels().apply {
        distance = queryDTO.distance
        latt_long = queryDTO.latt_long
        location_type = queryDTO.location_type
        title = queryDTO.title
        woeid = queryDTO.woeid
    }
}

fun QueryDTO.fromModels(queryModels: QueryModels): QueryDTO {
    return QueryDTO()
        .apply {
        distance = queryModels.distance
        latt_long = queryModels.latt_long
        location_type = queryModels.location_type
        title = queryModels.title
        woeid = queryModels.woeid
    }
}