package com.example.atl_unec2.sevice

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.atl_unec2.R


class ForegroundService :Service() {
//    override fun onBind(p0: Intent?): IBinder? {
//        return null
//    }
//
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        Thread {
//            while (true) {
//                Log.e("Service", "Foreground service is running...")
//                try {
//                    Thread.sleep(2000)
//                } catch (e: InterruptedException) {
//                    e.printStackTrace()
//                }
//            }
//        }.start()
//        return super.onStartCommand(intent, flags, startId)
//
//    }



    private val CHANNEL_ID = "ForegroundServiceChannel"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText("Foreground service is running")
            .setSmallIcon(R.drawable.baseline_home_24)
            .build()

        startForeground(1, notification)

        // Do heavy work on a background thread
        Thread {
            while (true) {
                Log.d("ForegroundService", "Foreground service is running...")
                Thread.sleep(5000)
            }
        }.start()

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager: NotificationManager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }
}