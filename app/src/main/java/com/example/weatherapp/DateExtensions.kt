package com.example.weatherapp

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

fun Long.toMonthDay(): String{
    val formatter = DateTimeFormatter.ofPattern("MMM dd")
    val dateTime = LocalDateTime.ofEpochSecond(this,0, ZoneOffset.of("-5"))
    return formatter.format(dateTime)
}

fun Long.toHourMinute(): String{
    val formatter = DateTimeFormatter.ofPattern("h:mm a")
    val dateTime = LocalDateTime.ofEpochSecond(this,0, ZoneOffset.of("-5"))
    return formatter.format(dateTime)
}
