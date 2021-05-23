package com.example.mobile.pruebabold.data_source.data_access.maper.maper_woeid

import com.example.mobile.pruebabold.data_source.data_access.dto.dto_woeid.ConsolidatedWeatherDTO
import com.example.mobile.pruebabold.models.models_woeid.ConsolidatedWeatherModels

fun ConsolidatedWeatherModels.fromDTO(consolidatedWeatherDTO: ConsolidatedWeatherDTO): ConsolidatedWeatherModels {
    return ConsolidatedWeatherModels()
        .apply {
        id = consolidatedWeatherDTO.id
        weather_state_name = consolidatedWeatherDTO.weather_state_name
        weather_state_abbr = consolidatedWeatherDTO.weather_state_abbr
        wind_direction_compass = consolidatedWeatherDTO.wind_direction_compass
        created = consolidatedWeatherDTO.created
        applicable_date = consolidatedWeatherDTO.applicable_date
        min_temp = consolidatedWeatherDTO.min_temp
        max_temp = consolidatedWeatherDTO.max_temp
        wind_speed = consolidatedWeatherDTO.wind_speed
        wind_direction = consolidatedWeatherDTO.wind_direction
        air_pressure = consolidatedWeatherDTO.air_pressure
        humidity = consolidatedWeatherDTO.humidity
        visibility = consolidatedWeatherDTO.visibility
        predictability = consolidatedWeatherDTO.predictability
    }
}

fun ConsolidatedWeatherDTO.fromModels(consolidatedWeatherModels: ConsolidatedWeatherModels): ConsolidatedWeatherDTO {
    return ConsolidatedWeatherDTO()
        .apply {
        id = consolidatedWeatherModels.id
        weather_state_name = consolidatedWeatherModels.weather_state_name
        weather_state_abbr = consolidatedWeatherModels.weather_state_abbr
        created = consolidatedWeatherModels.created
        applicable_date = consolidatedWeatherModels.applicable_date
        min_temp = consolidatedWeatherModels.min_temp
        max_temp = consolidatedWeatherModels.max_temp
        wind_speed = consolidatedWeatherModels.wind_speed
        wind_direction = consolidatedWeatherModels.wind_direction
        air_pressure = consolidatedWeatherModels.air_pressure
        humidity = consolidatedWeatherModels.humidity
        visibility = consolidatedWeatherModels.visibility
        predictability = consolidatedWeatherModels.predictability
    }
}