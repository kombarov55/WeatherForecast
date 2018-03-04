package com.example.nikolay.weatherforecast

import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

/**
 * Created by nikolay on 04.03.18.
 */

fun <T> JSONArray.map(mapper: (JSONObject) -> T): List<T> {
    val result = mutableListOf<T>()

    for (i in 0 until length()) {
        result.add(mapper(getJSONObject(i)))
    }

    return result
}

@Throws(IOException::class)
fun fileToString(fileInputStream: InputStream): String {

    val sb = StringBuilder()
    val byteArray = ByteArray(1024 * 8)

    while (fileInputStream.available() > 0) {
        fileInputStream.read(byteArray)
        sb.append(String(byteArray))
    }

    return sb.toString()
}

fun farenheitToCelsium(temperature: Int): Float = (temperature - 32).toFloat() * (5F / 9F)

fun farenheitToCelsium(temperature: String): String = trunc1(farenheitToCelsium(temperature.toInt()).toString())

fun trunc1(numAsStr: String): String = numAsStr.substring(0, numAsStr.indexOf(".") + 2)