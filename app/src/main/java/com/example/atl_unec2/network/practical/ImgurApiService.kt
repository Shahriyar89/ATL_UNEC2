package com.example.atl_unec2.network.practical

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ImgurApiService {
    @Multipart
    @POST("image/")
    fun uploadImage(
        @Header("Authorization") authorization: String,
        @Part image: MultipartBody.Part,
        @Part("title") title: RequestBody
    ): Call<UploadResponse>
}
