package com.example.atl_unec.workmanager

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.atl_unec2.databinding.ActivityWorkManagerBinding

class WorkManagerActivity : AppCompatActivity() {

    lateinit var binding: ActivityWorkManagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkManagerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        startImageDownloadWorker()

        startPeriodicWorkManager()

    }


    /**
     *
     * One time request tipinde worker yazin
     * Activiy / fragment uzerinde OneTimeWorker buttonu elave ederek clickinde
     * uygun One Time Request Worker classinin islemesini temin edin
     *
     *
     * PeriodicWorker yazin
     * Activiy / fragment uzerinde PeriodicWorker buttonu elave ederek clickinde PeriodicWorker classinin
     * islemesini temine din
     *
     *
     */


    fun startImageDownloadWorker() {
        val imageUrl =
            "https://w7.pngwing.com/pngs/895/199/png-transparent-spider-man-heroes-download-with-transparent-background-free-thumbnail.png"
        val inputData = workDataOf("image_url" to imageUrl)
        val downloadWorkRequest = OneTimeWorkRequest.Builder(ImageDownloadWorker::class.java)
            .setInputData(inputData)
            .build()

        WorkManager.getInstance(this).enqueue(downloadWorkRequest)

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(downloadWorkRequest.id)
            .observe(this, Observer { workInfo ->
                if (workInfo != null && workInfo.state.isFinished) {
                    val uriString = workInfo.outputData.getString("image_uri")
                    val uri = Uri.parse(uriString)
                    binding.imageView.setImageURI(uri)
                }
            })
    }


    private fun startPeriodicWorkManager() {
        val workManager = WorkManager.getInstance(applicationContext)

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(false)
            .build()

        val periodicWorkRequest = PeriodicWorkRequest.Builder(
            PeriodicWorkManager::class.java,
            15, // Repeat interval in minutes
            java.util.concurrent.TimeUnit.MINUTES
        )
            .setConstraints(constraints)
            .build()


        workManager.enqueueUniquePeriodicWork(
            "PeriodicWorkManager",
            ExistingPeriodicWorkPolicy.KEEP,
            periodicWorkRequest
        )

        workManager.getWorkInfoByIdLiveData(periodicWorkRequest.id).observe(this, Observer { workInfo ->
            if (workInfo != null && workInfo.state.isFinished) {
                Log.i("WorkManagerActivity", "Periodic work finished: ${workInfo.state}")
            }
        })
    }
}
