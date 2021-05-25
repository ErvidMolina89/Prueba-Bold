package com.example.mobile.pruebabold.models.models_woeid

import com.example.mobile.pruebabold.models.Base
import com.example.mobile.pruebabold.models.models_woeid.ConsolidatedWeatherModels
import com.example.mobile.pruebabold.models.models_woeid.ParentModels
import com.example.mobile.pruebabold.models.models_woeid.SourceModels

class WoeidModels : Base {

    var consolidated_weather: MutableList<ConsolidatedWeatherModels>? = null
    var latt_long: String? = null
    var location_type: String? = null
    var parent: ParentModels? = null
    var sources: MutableList<SourceModels>? = null
    var sun_rise: String? = null
    var sun_set: String? = null
    var time: String? = null
    var timezone: String? = null
    var timezone_name: String? = null
    var title: String? = null
    var woeid: Int? = null

}