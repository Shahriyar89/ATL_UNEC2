package com.example.atl_unec2.coroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.atl_unec2.room.sign_in_up.repository.LocalRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class KotlionFlowsViewmodel(repository: LocalRepository) : ViewModel() {

    private var _liveData = MutableLiveData<String>("Hello world")
    val liveData: LiveData<String> = _liveData

    private var _stateFlow = MutableStateFlow<String>("Hello world")
    val stateFlow = _stateFlow.asStateFlow()

    private var _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow = _sharedFlow.asSharedFlow()


    fun triggerLiveData() {
        _liveData.value = "Live data"
    }

     fun triggerStateFlow() {
        _stateFlow.value = "State Flow"
    }

    fun triggerFlow() = flow<String> {
        repeat(5) {
            emit(it.toString())
            delay(1000L)
        }
    }

    fun triggerSharedFlow() {
        viewModelScope.launch {
            _sharedFlow.emit("Shared Flow")
        }
    }


}