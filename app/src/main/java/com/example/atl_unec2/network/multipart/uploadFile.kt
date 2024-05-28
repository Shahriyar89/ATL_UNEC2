package com.example.atl_unec2.network.multipart

import android.util.Log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

fun uploadFile(file: File, description: String) {
    val (filePart, descriptionPart) = createMultipartBodyPart(file, description)
    val call = RetrofitClient.instance.uploadFile(filePart, descriptionPart)

    call.enqueue(object : Callback<ResponseBody> {
        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            if (response.isSuccessful) {
                // File upload successful
               Log.d("ResponseValue","Success ${response.body()?.string()})")
            } else {
                // Handle error
                Log.d("ResponseValue","Fail ${response.errorBody()?.string()}")
            }
        }

        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            // Handle failure
            Log.d("ResponseValue","Error ${t.message}")        }
    })
}
