package com.example.atl_unec2.coroutines.network.repository

import com.example.atl_unec2.base.BaseRepository
import com.example.atl_unec2.coroutines.network.MoviesApi
import com.example.atl_unec2.coroutines.network.Resource
import com.example.atl_unec2.coroutines.network.RetrofitClient
import com.example.atl_unec2.coroutines.network.model.PlayNowMovie
import com.example.atl_unec2.coroutines.network.model.PopularMovie
import kotlinx.coroutines.flow.Flow

class MoviesRepository : BaseRepository() {
    var service: MoviesApi = RetrofitClient.instance.create(MoviesApi::class.java)


    suspend fun getPlayNowMovies(): Flow<Resource<PlayNowMovie>> {
        return makeNetworkCall { service.getPlayNowMovies() }
    }

    suspend fun getPopularMovies():Flow<Resource<PopularMovie>>{
        return makeNetworkCall { service.getPopularMovies() }
    }
}
/**
 *
 * Her hansi endpoint (web service call) sorgu gondereceyik
 * web servise interface  + Repostiory + Viewmodel + Fragment
 * Api response ni Flow ile repositoriden viewModele gonderilmeli. Eyni zamanda viewModeldende datalari
 fragmente(Activiye) Flow vasitesi ile gondereceyik

 *
 */

