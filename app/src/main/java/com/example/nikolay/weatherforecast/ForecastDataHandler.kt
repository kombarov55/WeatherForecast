package com.example.nikolay.weatherforecast

import com.example.nikolay.weatherforecast.model.ForecastItem
import org.json.JSONObject

/**
 * Created by nikolay on 04.03.18.
 */
class ForecastDataHandler(json: String) {
    private val query: JSONObject = JSONObject(json).getJSONObject("query")

    private val channel: JSONObject = query
            .getJSONObject("results")
            .getJSONObject("channel")

    private val location = channel.getJSONObject("location")


    val creationDate: String = query.getString("created")

    val city: String = location.getString("city")
    val country: String = location.getString("country")
    val region: String = location.getString("region")


    val forecastItems: List<ForecastItem> = channel
            .getJSONObject("item")
            .getJSONArray("forecast")
            .map {
                ForecastItem(
                        date = it.getString("date"),
                        day = it.getString("day"),
                        high = farenheitToCelsium(it.getInt("high")),
                        low = farenheitToCelsium(it.getInt("low")),
                        text = it.getString("text"))
            }

    fun getTodayForecast(): ForecastItem? = forecastItems[0]

}