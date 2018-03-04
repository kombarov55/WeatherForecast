package com.example.nikolay.weatherforecast

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import com.example.nikolay.weatherforecast.model.ForecastItem

class MainActivity : AppCompatActivity() {

    //54.191263,37.6138233

    private lateinit var fab: FloatingActionButton

    private lateinit var forecastDataHandler: ForecastDataHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.forecast_layout)
        setSupportActionBar(findViewById(R.id.toolbar))

        val json = fileToString(resources.openRawResource(R.raw.sample))
        forecastDataHandler = ForecastDataHandler(json)


        findViewById<ListView>(R.id.forecast_listview)
                .setAdapter(ForecastAdapter(forecastDataHandler.forecastItems, layoutInflater))



        fab = findViewById(R.id.forecast_layout_fab)
    }

    override fun onStart() {
        super.onStart()

        fab.setOnClickListener({
            startActivity(Intent("VIEW_MY_ACTIVITY"))
        })
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
