package com.example.atl_unec2.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TestMoviesViewmodel @Inject constructor(repository:TestMoviesRepository): ViewModel() {

    fun getPlayMovies() {
        viewModelScope.launch {
//            repository.getPlayMovies()

        }
    }
}