package com.example.atl_unec2.di

import com.example.atl_unec2.coroutines.network.MoviesApi
import com.example.atl_unec2.network.multipart.ApiService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject


class TestMoviesRepository @Inject constructor() {

    suspend fun getPlayMovies() {
//        service.getPlayNowMovies()

        /**
         *
         * yeni ve ya var olan proyektinizi DI -Hilt le yazin
         * Flow ve ya LiveData + Retrofit- API + Repository +Viewmodel+Fragment ve ya Activity
         * Dependency Injection Hilt tetbiq edilecek - @HiltAndroidApp , field ve ya constructor Inject ,
          @AndroidEntryPoint istifade edilmelidir
         *
         */


    }
}