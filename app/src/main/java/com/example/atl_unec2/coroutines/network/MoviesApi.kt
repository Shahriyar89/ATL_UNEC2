package com.example.atl_unec2.coroutines.network

import com.example.atl_unec2.coroutines.network.model.PlayNowMovie
import com.example.atl_unec2.coroutines.network.model.PopularMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MoviesApi {
   companion object {
       val TOKEN="Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYzJkZjFlMzJmMjljYjBkN2I1OTE5YWFjODA5ZjJiMCIsInN1YiI6IjYwNWMzYzBhNDI2YWU4MDAyOGFmZDUzMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gHQ0cK6gd8tD4Zy4erI6va4Qnnp-S5ifTTnSqPrhAiI"
   }

    @GET("movie/now_playing")
    suspend fun getPlayNowMovies(
        @Header("Authorization") header: String = TOKEN
    ): Response<PlayNowMovie>


    @GET("movie/movie/popular")
    suspend fun getPopularMovies(
        @Header("Authorization") header: String = TOKEN,
        @Query("page") page: Int = 1
    ): Response<PopularMovie>
}