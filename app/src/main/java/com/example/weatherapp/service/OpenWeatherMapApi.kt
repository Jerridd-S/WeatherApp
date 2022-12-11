package com.example.weatherapp.service

import com.example.weatherapp.models.CurrentConditions
import com.example.weatherapp.models.Forecast
import retrofit2.http.GET
import retrofit2.http.Query


interface OpenWeatherMapApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentCondition(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "940096c4c8465d186bd8ecbff2803d66",
        @Query("units") units: String = "imperial",
    ) : CurrentConditions

    @GET("data/2.5/weather")
    suspend fun getCurrentCondition(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey: String = "940096c4c8465d186bd8ecbff2803d66",
        @Query("units") units: String = "imperial",
    ) : CurrentConditions

    @GET("data/2.5/forecast/daily")
    suspend fun getForecast(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "940096c4c8465d186bd8ecbff2803d66",
        @Query("cnt") cnt: Int = 16,
        @Query("units") units: String = "imperial",
    ) : Forecast

    @GET("data/2.5/forecast/daily")
    suspend fun getForecast(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey: String = "940096c4c8465d186bd8ecbff2803d66",
        @Query("cnt") cnt: Int = 16,
        @Query("units") units: String = "imperial",
    ) : Forecast
}