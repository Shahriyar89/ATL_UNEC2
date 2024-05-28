package com.example.atl_unec2.network

import com.example.atl_unec2.room.lesson.User
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path


//https://mysales.com/customers/all
//https://mysales.com/customers/add

interface MyServices {
    @GET("random")
    fun fetchData(
    ): Call<DogModel>




    @Multipart
    @POST("user")
    fun uploadImage(
       @Part file: MultipartBody.Part
    ):Any







    @PUT("updateUser")
    fun updateUser(
        @Body user: User
    )

    @DELETE("deleteUser")
    fun deleteUser(
        @Path("id") userId:String
    )

}