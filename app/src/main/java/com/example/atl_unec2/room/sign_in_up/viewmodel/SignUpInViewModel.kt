package com.example.atl_unec2.room.sign_in_up.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.atl_unec2.room.sign_in_up.model.Person
import com.example.atl_unec2.room.sign_in_up.repository.LocalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class SignUpInViewModel(application: Application) : AndroidViewModel(application) {

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
        viewModelScope.launch {
            _stateFlow.emit("")
        }
    }

    fun triggerFlow() = flow<String> {
        repeat(5) {
            emit(it.toString())
            delay(1000L)
        }
    }

    fun triggerSharedFlow() {
        viewModelScope.launch {
            _sharedFlow.emit("SharedFlow")
        }
    }


    val repository = LocalRepository(application)
    var isPersonAvailable = MutableLiveData(false)
    var allPersons: Flow<List<Person>>? = repository.getAllPerson()

    fun getAllPersons(){
        val sharedFlow = allPersons?.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = 0
        )
    }




    fun registerUser(person: Person) {
        repository.insertPerson(person)
    }

    fun isPersonAvailable(name: String, pass: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = repository.getPerson(name, pass)
            user?.let { isPersonAvailable.postValue(true) }
        }
    }


}