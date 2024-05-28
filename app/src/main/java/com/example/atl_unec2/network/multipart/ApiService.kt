package com.example.atl_unec2.network.multipart

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.Call
import retrofit2.http.Path

interface ApiService {
    @Multipart
    @POST("/v2/accounts/{accountId}/uploads/form_data")
    fun uploadFile(
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
        @Path ("accountId") string: String="W142icT"
    ): Call<ResponseBody>
}
