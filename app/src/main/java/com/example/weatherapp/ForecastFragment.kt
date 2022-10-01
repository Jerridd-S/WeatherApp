package com.example.weatherapp

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.weatherapp.databinding.FragmentForecastBinding
import java.time.Instant.ofEpochSecond
import java.time.LocalDateTime
import java.time.LocalDateTime.ofEpochSecond
import java.time.LocalTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter


val forecastData = listOf<DayForecast>(

    DayForecast(1662003300L,600,1900, ForecastTemp(56.0F, 69.0F), 56.6F, 90),
    DayForecast(1662089700L,601,1901, ForecastTemp(65.0F, 70.0F), 42.0F, 78),
    DayForecast(1662176100L,602,1902, ForecastTemp(78.0F, 71.0F), 65.7F, 98),
    DayForecast(1662262500L,603,1903, ForecastTemp(55.0F, 72.0F), 52.1F, 68),
    DayForecast(1662348900L,604,1904, ForecastTemp(56.0F, 78.0F), 53.2F, 65),
    DayForecast(1662435300L,605,1905, ForecastTemp(58.0F, 75.0F), 58.6F, 55),
    DayForecast(1662521700L,606,1906, ForecastTemp(60.0F, 68.0F), 57.6F, 66),
    DayForecast(1662608100L,607,1907, ForecastTemp(65.0F, 63.0F), 65.6F, 88),
    DayForecast(1662694500L,608,1908, ForecastTemp(68.0F, 67.0F), 52.4F, 77),
    DayForecast(1662780900L,609,1909, ForecastTemp(64.0F, 62.0F), 63.6F, 99),
    DayForecast(1662867300L,610,1910, ForecastTemp(62.0F, 69.0F), 64.5F, 89),
    DayForecast(1662953700L,611,1911, ForecastTemp(69.0F, 72.0F), 78.6F, 99),
    DayForecast(1663040100L,612,1912, ForecastTemp(66.0F, 76.0F), 64.6F, 89),
    DayForecast(1663126500L,613,1913, ForecastTemp(78.0F, 75.0F), 75.7F, 79),
    DayForecast(1663212900L,614,1914, ForecastTemp(77.0F, 74.0F), 65.6F, 69),
    DayForecast(1663299300L,615,1914, ForecastTemp(73.0F, 73.0F), 26.6F, 59),
)


class ForecastFragment : Fragment(R.layout.fragment_forecast){
    private lateinit var binding: FragmentForecastBinding
    private val args: ForecastFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        binding.forecastList.adapter = ForecastAdapter(forecastData)

        val dateTimeStamp = 1662003300L // Sept 1
        val formatter = DateTimeFormatter.ofPattern("MMM dd")
        val dateTime = LocalDateTime.ofEpochSecond(dateTimeStamp,0,ZoneOffset.of("-5"))
        val formattedDate = formatter.format(dateTime)

        val timeFormatter = DateTimeFormatter.ofPattern("h:mm a")
        val forematedTime = timeFormatter.format(dateTime)

        Log.d("ForecastFragment", formattedDate)
        Log.d("ForecastFragment", forematedTime)
    }
}