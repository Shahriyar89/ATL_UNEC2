package com.example.atl_unec2.coroutines.network

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.atl_unec2.coroutines.network.model.PlayNowMovie
import com.example.atl_unec2.coroutines.network.repository.MoviesRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import retrofit2.Response

class MoviesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: MovieRepository = MovieRepository()
    private val repo: MoviesRepository = MoviesRepository()

    val moviesData = MutableLiveData<Resource<PlayNowMovie>>()
    private var _moviesFlowData = MutableStateFlow<Resource<PlayNowMovie>>(Resource.Loading())
    val moviesFlowData: StateFlow<Resource<PlayNowMovie>> get() = _moviesFlowData




    //
    var moviesDataFlow:MutableStateFlow<Resource<PlayNowMovie>> =MutableStateFlow(Resource.Loading())

//    val moviesData = MutableLiveData<Resource<PlayNowMovie>>()


    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Handle $exception in CoroutineExceptionHandler")
    }


    fun getPlayMovies() {
        _moviesFlowData.value = Resource.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            val result = repo.getPlayNowMovies()
            result.collect {
                _moviesFlowData.value = it
            }
        }
    }

    fun getPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getPopularMovies()
            if (result.isSuccessful) {
                val data = result.body()
                Log.d("MoviesData", "$data")
            }
        }
    }



    //new method

    fun getPlayMoviesFlow() {
        viewModelScope.launch {
            val data = repository.getPlayNowMovies()
            data.collect {
                    moviesDataFlow.value = handleMoviesResponse(it)

            }
        }
    }



    fun getAllApi() {
        viewModelScope.launch {
            supervisorScope {
                val playM = repository.getPlayNowMovies()
                val popularM = repository.getPopularMovies()
            }
        }
    }


    fun workAsAsync() {
        val defer1 = viewModelScope.async { getPlayMovies() }
        val defer2 = viewModelScope.async { getPopularMovies() }

        viewModelScope.launch {

            val a = defer1.await()
            val b = defer2.await()

            // all deferred running at same time
            awaitAll(defer1, defer2)

        }


    }


    fun runScopes() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {


        }
    }


    private fun handleMoviesResponse(response: Response<PlayNowMovie>): Resource<PlayNowMovie> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    override fun onCleared() {
        super.onCleared()

    }
}