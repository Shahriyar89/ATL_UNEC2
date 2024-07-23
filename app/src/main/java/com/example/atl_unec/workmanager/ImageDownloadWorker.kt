package com.example.atl_unec.workmanager

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class ImageDownloadWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val imageUrl = inputData.getString("image_url")
        return try {
            val bitmap = downloadImage(imageUrl!!)
            if (bitmap != null) {
                val uri = saveImageToInternalStorage(bitmap)
                Result.success(workDataOf("image_uri" to uri.toString()))
            } else {
                Result.failure()
            }
        } catch (e: Exception) {
            Log.e("ImageDownloadWorker", "Error downloading image", e)
            Result.failure()
        }
    }

    private fun downloadImage(urlString: String): Bitmap? {
        return try {
            val url = URL(urlString)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input: InputStream = connection.inputStream
            BitmapFactory.decodeStream(input)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun saveImageToInternalStorage(bitmap: Bitmap): Uri {
        val filename = "downloaded_image.png"
        val stream = applicationContext.openFileOutput(filename, Context.MODE_PRIVATE)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        stream.close()
        return Uri.fromFile(applicationContext.getFileStreamPath(filename))
    }
}
