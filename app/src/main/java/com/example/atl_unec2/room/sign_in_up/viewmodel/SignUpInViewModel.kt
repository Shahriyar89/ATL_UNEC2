package com.example.atl_unec2.room.sign_in_up.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.atl_unec2.room.sign_in_up.model.Person
import com.example.atl_unec2.room.sign_in_up.repository.LocalRepository


class SignUpInViewModel(application: Application) : AndroidViewModel(application) {

    val repository = LocalRepository(application)
    var isPersonAvailable = MutableLiveData(false)

    fun registerUser(person: Person) {
        repository.insertPerson(person)
    }

    fun isPersonAvailable(name: String, pass: String) {
        val user = repository.getPerson(name, pass)
        user?.let { isPersonAvailable.postValue(true) }
    }

}