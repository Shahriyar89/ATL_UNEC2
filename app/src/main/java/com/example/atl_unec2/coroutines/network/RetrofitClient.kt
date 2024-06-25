package com.example.atl_unec2.coroutines.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val authInterceptor=AuthInterceptor()

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
//        .addInterceptor(authInterceptor)
        .build()

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    class AuthInterceptor() : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
                .addHeader("Authorization:", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYzJkZjFlMzJmMjljYjBkN2I1OTE5YWFjODA5ZjJiMCIsInN1YiI6IjYwNWMzYzBhNDI2YWU4MDAyOGFmZDUzMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gHQ0cK6gd8tD4Zy4erI6va4Qnnp-S5ifTTnSqPrhAiI")
                .build()
            return chain.proceed(request)
        }
    }
}
