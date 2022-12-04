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



@Composable
fun ForecastScreen(
    viewModel: ForecastViewModel = hiltViewModel(),
){

    val state by viewModel.forecast.collectAsState(null)

    LaunchedEffect(Unit){
        viewModel.fetchData()
    }

    Column {
        state?.let {
            for(i in 0 until it.count){
                ForecastRow(it, i)
            }
        }
    }
}

@Composable
private fun ForecastRow(
    item: Forecast,
    index: Int
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
            text = item.list[index].dateTime.toMonthDay(),
            style = TextStyle(
                fontSize = 16.sp,
            )
        )
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column() {
            Text(
                text = stringResource(R.string.high, item.list[index].temperatures.maxTemperature.toInt()),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.low, item.list[index].temperatures.minTemperature.toInt()),
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
                text = stringResource(id = R.string.sunrise, item.list[index].sunrise.toHourMinute()),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.sunset, item.list[index].sunset.toHourMinute()),
                style = textStyle,
            )
        }
    }
}

//@Preview(
//    showSystemUi = true,
//)
//@Composable
//fun ForecastRowPreview(){
//    ForecastRow(item = forecastData[0])
//}