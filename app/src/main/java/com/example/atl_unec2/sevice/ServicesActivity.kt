package com.example.atl_unec2.sevice

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.atl_unec2.databinding.ActivityServicesBinding


class ServicesActivity : AppCompatActivity() {
    lateinit var binding: ActivityServicesBinding

    private val airplaneModeReceiver = AirPlaneModeReceiver()
    val testReceiver = TestBroadcastReceiver()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        val backgroundService = Intent(this, BackgroundService::class.java)
//        startService(backgroundService)
//
        val foregroundService=Intent(this,ForegroundService::class.java)
        startService(foregroundService)


//        registerReceiver(airplaneModeReceiver, IntentFilter(Intent.ACTION_BATTERY_LOW))

//        registerReceiver(testReceiver, IntentFilter("ACTION_TEST"))

        binding.sendBroadcast.setOnClickListener {
            sendBroadcast(Intent("ACTION_TEST"))
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneModeReceiver)
    }
}