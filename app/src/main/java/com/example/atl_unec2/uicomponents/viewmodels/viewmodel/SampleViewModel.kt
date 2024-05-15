package com.example.atl_unec2.uicomponents.viewmodels.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SampleViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {



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


    override fun onCleared() {
        super.onCleared()
        Log.d("ViewModel","  Cleared")
    }
}