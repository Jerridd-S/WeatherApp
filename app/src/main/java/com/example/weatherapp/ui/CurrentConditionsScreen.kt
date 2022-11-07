package com.example.weatherapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.weatherapp.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentConditions(
    onForecastButtonClick: () -> Unit,
){
    Scaffold(
        topBar = { AppBar(title = stringResource(id = R.string.app_name)) }
    ) {
        CurrentConditionsContent {
            onForecastButtonClick()
        }
    }
}

@Composable
private fun CurrentConditionsContent(
    onForecastButtonClick: () -> Unit,
){
    Column(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = stringResource(id = R.string.city_name,"St.Paul, MN"),
            style = TextStyle(
                fontWeight = FontWeight(600),
                fontSize = 24.sp
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row (
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = stringResource(id = R.string.current_temp,102),
                    style = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 72.sp,
                    )
                )
                Text(
                    text = stringResource(id = R.string.feels_like, 110),
                    style = TextStyle(
                        fontSize = 12.sp,
                    )
                )
            }
            Spacer(Modifier.weight(1f, fill = true))
            Image(
                modifier = Modifier.size(72.dp),
                painter = painterResource(R.drawable.clear_sky),
                contentDescription = "Sunny"
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            val textStyle = TextStyle(
                fontSize = 16.sp,
            )
            Text(text = stringResource(id = R.string.low,98), style = textStyle)
            Text(text = stringResource(id = R.string.high,110), style = textStyle)
            Text(text = stringResource(id = R.string.humidity,110), style = textStyle)
            Text(text = stringResource(id = R.string.pressure,110), style = textStyle)
        }

        Spacer(modifier = Modifier.height(72.dp))
        Button(onClick = onForecastButtonClick){
            Text(text = stringResource(id = R.string.forecast))
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun CurrentConditionsPreview(){
    CurrentConditions {}
}