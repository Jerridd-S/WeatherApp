package com.example.weatherapp.models

import com.example.weatherapp.models.Forecast

data class DayForecast(

    val date: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: ForecastTemp,
    val pressure: Float,
    val humidity: Int
)

data class ForecastTemp(
    val min: Float,
    val max: Float
)