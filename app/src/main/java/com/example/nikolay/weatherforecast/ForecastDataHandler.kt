package com.example.nikolay.weatherforecast

import com.example.nikolay.weatherforecast.model.ForecastItem
import org.json.JSONObject

/**
 * Created by nikolay on 04.03.18.
 */
class ForecastDataHandler(json: String) {
    private val query: JSONObject = JSONObject(json).getJSONObject("query")

    private val item: JSONObject = query
            .getJSONObject("results")
            .getJSONObject("channel")
            .getJSONObject("item")

    val creationDate = query.getString("created")
    val forecastItems: List<ForecastItem> = item
            .getJSONArray("forecast")
            .map {
                ForecastItem(
                        day = it.getString("day"),
                        high = it.getString("high"),
                        low = it.getString("low"),
                        text = it.getString("text"))
            }
}