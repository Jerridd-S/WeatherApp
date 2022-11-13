package com.example.weatherapp.models

import com.squareup.moshi.Json

data class MinMaxTemp(
    @Json(name = "min") val minTemperature: Float,
    @Json(name = "max") val maxTemperature: Float,
)

data class ListData(
    @Json(name = "dt") val dateTime: Long,
    @Json(name = "temp") val temperatures: MinMaxTemp,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long,
)

data class Forecast(
    @Json(name = "list") val data: ListData,
)
