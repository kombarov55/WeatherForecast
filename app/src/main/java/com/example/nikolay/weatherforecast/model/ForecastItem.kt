package com.example.nikolay.weatherforecast.model

import com.example.nikolay.weatherforecast.trunc1

/**
 * Created by nikolay on 01.03.18.
 */
data class ForecastItem(
        val date: String,
        val day: String,
        val high: Float,
        val low: Float,
        val text: String
) {
    fun middleTemperature(): String {
        val temp = (high + low) / 2
        val sign = if (temp > 0) "+" else ""

        return trunc1(sign + temp)
    }
}