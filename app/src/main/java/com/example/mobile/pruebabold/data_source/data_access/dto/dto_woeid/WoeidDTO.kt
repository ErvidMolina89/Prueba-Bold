package com.example.mobile.pruebabold.data_source.data_access.dto.dto_woeid

import com.example.mobile.pruebabold.data_source.data_access.dto.dto_woeid.ConsolidatedWeatherDTO
import com.example.mobile.pruebabold.data_source.data_access.dto.dto_woeid.ParentDTO
import com.example.mobile.pruebabold.data_source.data_access.dto.dto_woeid.SourceDTO

class WoeidDTO {

    var consolidated_weather: MutableList<ConsolidatedWeatherDTO>? = null
    var latt_long: String? = null
    var location_type: String? = null
    var parent: ParentDTO? = null
    var sources: MutableList<SourceDTO>? = null
    var sun_rise: String? = null
    var sun_set: String? = null
    var time: String? = null
    var timezone: String? = null
    var timezone_name: String? = null
    var title: String? = null
    var woeid: Int? = null

}