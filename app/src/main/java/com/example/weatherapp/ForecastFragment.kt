package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.weatherapp.databinding.FragmentForecastBinding
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter


val forecastData = listOf<DayForecast>(

    DayForecast(1662003300L,1661927738L,1661975678L, ForecastTemp(56.0F, 69.0F), 56.6F, 90),
    DayForecast(1662089700L,1662014198L,1662061958L, ForecastTemp(65.0F, 70.0F), 42.0F, 78),
    DayForecast(1662176100L,1662100658L,1662148238L, ForecastTemp(78.0F, 71.0F), 65.7F, 98),
    DayForecast(1662262500L,1662187178L,1662234518L, ForecastTemp(55.0F, 72.0F), 52.1F, 68),
    DayForecast(1662348900L,1662273638L,1662320798L, ForecastTemp(56.0F, 78.0F), 53.2F, 65),
    DayForecast(1662435300L,1662360098L,1662407078L, ForecastTemp(58.0F, 75.0F), 58.6F, 55),
    DayForecast(1662521700L,1662446558L,1662493358L, ForecastTemp(60.0F, 68.0F), 57.6F, 66),
    DayForecast(1662608100L,1662533018L,1662579698L, ForecastTemp(65.0F, 63.0F), 65.6F, 88),
    DayForecast(1662694500L,1662579698L,1662579578L, ForecastTemp(68.0F, 67.0F), 52.4F, 77),
    DayForecast(1662780900L,1662705998L,1662752258L, ForecastTemp(64.0F, 62.0F), 63.6F, 99),
    DayForecast(1662867300L,1662792458L,1662838538L, ForecastTemp(62.0F, 69.0F), 64.5F, 89),
    DayForecast(1662953700L,1662878918L,1662924818L, ForecastTemp(69.0F, 72.0F), 78.6F, 99),
    DayForecast(1663040100L,1662965378L,1663011098L, ForecastTemp(66.0F, 76.0F), 64.6F, 89),
    DayForecast(1663126500L,1663051838L,1663097378L, ForecastTemp(78.0F, 75.0F), 75.7F, 79),
    DayForecast(1663212900L,1663138358L,1663183658L, ForecastTemp(77.0F, 74.0F), 65.6F, 69),
    DayForecast(1663299300L,1663224818L,1663269938L, ForecastTemp(73.0F, 73.0F), 26.6F, 59),
)


class ForecastFragment : Fragment(R.layout.fragment_forecast){

    private lateinit var binding: FragmentForecastBinding
    private val args: ForecastFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        binding.forecastList.adapter = ForecastAdapter(forecastData)
    }
}