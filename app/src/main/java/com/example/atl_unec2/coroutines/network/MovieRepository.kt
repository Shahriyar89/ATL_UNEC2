package com.example.atl_unec2.coroutines.network

import com.example.atl_unec2.coroutines.network.model.PlayNowMovie
import com.example.atl_unec2.coroutines.network.model.PopularMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MovieRepository {
    var service:MoviesApi=RetrofitClient.instance.create(MoviesApi::class.java)

    suspend fun getPlayNowMovies(): Flow<Response<PlayNowMovie>>
    = flow {
        val response = service.getPlayNowMovies()
        emit(response)
    }

    suspend fun getPopularMovies(): Response<PopularMovie> {
        return service.getPopularMovies()
    }
}