package com.example.atl_unec.sevice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log



class BackgroundService :Service() {

    companion object{
        var serviceStop : (()->Unit)?=null
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Thread {
            while (true) {
                Log.e("BG_SERVICE", "Background service is running...")
                try {
                    Thread.sleep(2000)
                serviceStop={ Thread.interrupted()}

                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("BG_SERVICE", "Background service is destroyed")
    }

}


/**
 *
 * Background service yazaraq baslayanda ve bitende UI uzerinde toast gosterilsin
 * Foreground service yazaraq notification gosterilsin
 * WiFi active olub olmamasinin broadcast recevierini yazin
 *
 *
 */


