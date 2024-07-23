package com.example.atl_unec.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class PeriodicWorkManager(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {
    override fun doWork(): Result {
        return try {
            val time = SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.getDefault())
            val timeString = time.format(Date())
            Log.i("PeriodicWorkManager", "Current time: $timeString")
            Result.success()
        } catch (e: Exception) {
            Log.e("PeriodicWorkManager", "Error during work", e)
            Result.failure()
        }
    }
}
