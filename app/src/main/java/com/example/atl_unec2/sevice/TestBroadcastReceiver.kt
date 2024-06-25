package com.example.atl_unec2.sevice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class TestBroadcastReceiver :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action=="ACTION_TEST"){
            Log.d("TestReceiver", "Received")
        }
    }
}