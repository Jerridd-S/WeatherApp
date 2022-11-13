package com.example.weatherapp.models

import com.squareup.moshi.Json

data class TempData(
    @Json(name = "min") val minTemperature: Float,
    @Json(name = "max") val maxTemperature: Float,
)

data class ListData(
    @Json(name = "dt") val dateTime: Long,
    @Json(name = "temp") val temperatures: TempData,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long,
)

data class Forecast(
    @Json(name = "list") val list: List<ListData>,
    @Json(name = "cnt") val count: Int,
)
