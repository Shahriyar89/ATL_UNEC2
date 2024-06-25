package com.example.atl_unec2.sevice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.util.Log

class AirPlaneModeReceiver : BroadcastReceiver() {
    override fun onReceive(contex: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val isTurnedOn = Settings.Global.getInt(
                contex?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON
            )!=0
            Log.d("AIRPLANE_MODE : ", "$isTurnedOn")
        }
    }
}