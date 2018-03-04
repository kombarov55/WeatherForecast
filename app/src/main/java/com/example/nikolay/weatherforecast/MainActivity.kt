package com.example.nikolay.weatherforecast

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var forecastListview: ListView
    private lateinit var cityLabel: TextView
    private lateinit var weatherTypeLabel: TextView
    private lateinit var currentTemperatureLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.forecast_layout)
        setSupportActionBar(findViewById(R.id.toolbar))

        forecastListview = findViewById(R.id.forecast_listview)
        cityLabel = findViewById(R.id.city_label)
        weatherTypeLabel = findViewById(R.id.weather_type)
        currentTemperatureLabel = findViewById(R.id.current_temperature)


    }

    override fun onStart() {
        super.onStart()

        val json = fileToString(resources.openRawResource(R.raw.sample))
        val forecastDataHandler = ForecastDataHandler(json)
        val todayForecast = forecastDataHandler.getTodayForecast() ?: forecastDataHandler.forecastItems[0]

        cityLabel.text = forecastDataHandler.city
        weatherTypeLabel.text = todayForecast.text

        currentTemperatureLabel.text = todayForecast.middleTemperature()

        forecastListview.setAdapter(ForecastAdapter(forecastDataHandler.forecastItems, layoutInflater))

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
