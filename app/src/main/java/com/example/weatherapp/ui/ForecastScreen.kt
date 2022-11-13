package com.example.weatherapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.R

import com.example.weatherapp.models.DayForecast
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.ForecastTemp
import com.example.weatherapp.toHourMinute
import com.example.weatherapp.toMonthDay


val forecastData = listOf(
    DayForecast(date = 1662003300L, sunrise = 1661927738L, sunset = 1661975678L, temp = ForecastTemp(min = 56.0F,max = 69.0F), pressure = 56.6F, humidity = 90),
    DayForecast(date = 1662089700L, sunrise = 1662014198L, sunset = 1662061958L, temp = ForecastTemp(min = 65.0F,max = 70.0F), pressure = 42.0F, humidity = 78),
    DayForecast(date = 1662176100L, sunrise = 1662100658L, sunset = 1662148238L, temp = ForecastTemp(min = 78.0F,max = 71.0F), pressure = 65.7F, humidity = 98),
    DayForecast(date = 1662262500L, sunrise = 1662187178L, sunset = 1662234518L, temp = ForecastTemp(min = 55.0F,max = 72.0F), pressure = 52.1F, humidity = 68),
    DayForecast(date = 1662348900L, sunrise = 1662273638L, sunset = 1662320798L, temp = ForecastTemp(min = 56.0F,max = 78.0F), pressure = 53.2F, humidity = 65),
    DayForecast(date = 1662435300L, sunrise = 1662360098L, sunset = 1662407078L, temp = ForecastTemp(min = 58.0F,max = 75.0F), pressure = 58.6F, humidity = 55),
    DayForecast(date = 1662521700L, sunrise = 1662446558L, sunset = 1662493358L, temp = ForecastTemp(min = 60.0F,max = 68.0F), pressure = 57.6F, humidity = 66),
    DayForecast(date = 1662608100L, sunrise = 1662533018L, sunset = 1662579698L, temp = ForecastTemp(min = 65.0F,max = 63.0F), pressure = 65.6F, humidity = 88),
    DayForecast(date = 1662694500L, sunrise = 1662579698L, sunset = 1662579578L, temp = ForecastTemp(min = 68.0F,max = 67.0F), pressure = 52.4F, humidity = 77),
    DayForecast(date = 1662780900L, sunrise = 1662705998L, sunset = 1662752258L, temp = ForecastTemp(min = 64.0F,max = 62.0F), pressure = 63.6F, humidity = 99),
    DayForecast(date = 1662867300L, sunrise = 1662792458L, sunset = 1662838538L, temp = ForecastTemp(min = 62.0F,max = 69.0F), pressure = 64.5F, humidity = 89),
    DayForecast(date = 1662953700L, sunrise = 1662878918L, sunset = 1662924818L, temp = ForecastTemp(min = 69.0F,max = 72.0F), pressure = 78.6F, humidity = 99),
    DayForecast(date = 1663040100L, sunrise = 1662965378L, sunset = 1663011098L, temp = ForecastTemp(min = 66.0F,max = 76.0F), pressure = 64.6F, humidity = 89),
    DayForecast(date = 1663126500L, sunrise = 1663051838L, sunset = 1663097378L, temp = ForecastTemp(min = 78.0F,max = 75.0F), pressure = 75.7F, humidity = 79),
    DayForecast(date = 1663212900L, sunrise = 1663138358L, sunset = 1663183658L, temp = ForecastTemp(min = 77.0F,max = 74.0F), pressure = 65.6F, humidity = 69),
    DayForecast(date = 1663299300L, sunrise = 1663224818L, sunset = 1663269938L, temp = ForecastTemp(min = 73.0F,max = 73.0F), pressure = 26.6F, humidity = 59),

)

@Composable
fun ForecastScreen(
    viewModel: ForecastViewModel = hiltViewModel(),
){

    val state by viewModel.forecast.collectAsState(null)

    LaunchedEffect(Unit){
        viewModel.fetchData()
    }

    LazyColumn {
        items(items = forecastData) { item: DayForecast ->
            ForecastRow(item = item)
        }
    }
}

@Composable
private fun ForecastRow(
    item: DayForecast,
){
    Row(
        modifier = Modifier
            .padding(
                top = 24.dp,
                bottom = 24.dp,
            )
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val textStyle = TextStyle(
            fontSize = 12.sp,
        )
        Image(
            painter = painterResource(id = R.drawable.clear_sky)
            , contentDescription = "",
            modifier = Modifier.padding(
                start = 12.dp
            ),
        )
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Text(
            text = item.date.toMonthDay(),
            style = TextStyle(
                fontSize = 16.sp,
            )
        )
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column() {
            Text(
                text = stringResource(id = R.string.high, item.temp.max.toInt()),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.low, item.temp.min.toInt()),
                style = textStyle,
            )
        }
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.padding(
            end = 12.dp,
            )
        ) {
            Text(
                text = stringResource(id = R.string.sunrise, item.sunrise.toHourMinute()),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.sunset, item.sunset.toHourMinute()),
                style = textStyle,
            )
        }
    }
}

@Preview(
    showSystemUi = true,
)
@Composable
fun ForecastRowPreview(){
    ForecastRow(item = forecastData[0])
}