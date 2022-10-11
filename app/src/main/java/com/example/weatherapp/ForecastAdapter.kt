package com.example.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class ForecastAdapter(private val data: List<DayForecast>) : RecyclerView.Adapter<ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.view_forecast_item,parent,false)
            .inflate(R.layout.fragment_day_forecast,parent,false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}

class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view)  {

    val monthDay: TextView
    val daysTemp: TextView
    val daysHigh: TextView
    val daysLow: TextView
    val daysSunrise: TextView
    val daysSunset: TextView

//    val forecastTemp: TextView

    init {
        monthDay = view.findViewById(R.id.monthDay)
        daysTemp = view.findViewById(R.id.daysTemp)
        daysHigh = view.findViewById(R.id.daysHigh)
        daysLow = view.findViewById(R.id.daysLow)
        daysSunrise = view.findViewById(R.id.daysSunrise)
        daysSunset = view.findViewById(R.id.daysSunset)

//        forecastTemp = view.findViewById(R.id.forecast_temp)
    }

    fun bind(data: DayForecast){
        monthDay.text = date(data.date)
        daysTemp.text = "Temp: " + data.temp.max.toString()
        daysHigh.text = "High: " + data.temp.max.toString()
        daysLow.text = "Low: " + data.temp.min.toString()
        daysSunrise.text = "Sunrise: " + sunriseSunset(data.sunrise)
        daysSunset.text = "Sunset: " + sunriseSunset(data.sunset)
    }

    fun date(data: Long): String {
        val dateTime = LocalDateTime.ofEpochSecond(data,0, ZoneOffset.of("-5"))
        val formatter = DateTimeFormatter.ofPattern("MMM dd")
        val formattedDate = formatter.format(dateTime)
        return formattedDate.toString()
    }

    fun sunriseSunset(data: Long): String{
        val dateTime = LocalDateTime.ofEpochSecond(data,0, ZoneOffset.of("-5"))
        val formatter = DateTimeFormatter.ofPattern("h:mm a")
        val formattedTime = formatter.format(dateTime)
        return formattedTime.toString()
    }

}