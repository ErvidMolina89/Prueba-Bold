package com.example.mobile.pruebabold.data_source.data_access.maper

import com.example.mobile.pruebabold.data_source.data_access.dto.SourceDTO
import com.example.mobile.pruebabold.models.SourceModels

fun SourceModels.fromDTO(sourceDTO: SourceDTO): SourceModels {
    return SourceModels().apply {
        crawl_rate = sourceDTO.crawl_rate
        slug = sourceDTO.slug
        title = sourceDTO.title
        url = sourceDTO.url
    }
}

fun SourceDTO.fromModels(sourceModels: SourceModels): SourceDTO {
    return SourceDTO().apply {
        crawl_rate = sourceModels.crawl_rate
        slug = sourceModels.slug
        title = sourceModels.title
        url = sourceModels.url
    }
}