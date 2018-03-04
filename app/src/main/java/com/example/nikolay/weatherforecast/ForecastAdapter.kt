package com.example.nikolay.weatherforecast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.nikolay.weatherforecast.model.ForecastItem

/**
 * Created by nikolay on 01.03.18.
 */
class ForecastAdapter(
        private val xs: List<ForecastItem>,
        private val inflater: LayoutInflater
) : BaseAdapter() {

    override fun getView(i: Int, view: View?, parent: ViewGroup?): View {
        val resultView = view ?: inflater.inflate(R.layout.forecast_item, parent, false)

        val x = xs[i]

        resultView.findViewById<TextView>(R.id.forecast_item_date).text = x.day
        resultView.findViewById<TextView>(R.id.forecast_item_max).text = x.high
        resultView.findViewById<TextView>(R.id.forecast_item_min).text = x.low
        resultView.findViewById<TextView>(R.id.forecast_item_text).text = x.text

        return resultView
    }

    override fun getItem(i: Int): Any  = xs[i]
    override fun getItemId(i: Int): Long = i.toLong()
    override fun getCount(): Int = xs.size
}