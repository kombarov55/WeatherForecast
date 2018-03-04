package com.example.nikolay.weatherforecast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

/**
 * Created by nikolay on 04.03.18.
 */
class MyReceiver : BroadcastReceiver() {

    override fun onReceive(ctx: Context?, intent: Intent?) {
        Log.d("MY_RECEIVER", "HELLO WORLD!")
        Toast.makeText(ctx, "Hello world!", Toast.LENGTH_SHORT).show()
    }
}