package com.example.atl_unec2.uicomponents.viewmodels.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus

class SampleViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {


    val job= CoroutineScope(Dispatchers.Default) + Job()


    //set oluna bilen data
    private var _observeData = MutableLiveData<Any>()
    //get olunacaq data
    val observeData: LiveData<Any> = _observeData

    private var number = 0

    val name: String = "ATL"


    fun countNumber(): String {
        val num = (number++).toString()
        _observeData.postValue(num)
        return num
    }

    fun setQuery(query: String) {
        savedStateHandle["query"] = query
    }


     fun getQuery()=savedStateHandle.get<String>("query")


    fun getAllUser(){
        viewModelScope.launch(Dispatchers.IO) {
//call api
        }



    }


    override fun onCleared() {
        super.onCleared()
        Log.d("ViewModel","  Cleared")
    }
}