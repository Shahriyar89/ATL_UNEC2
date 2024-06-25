package com.example.atl_unec2.room.sign_in_up.repository

import android.content.Context
import com.example.atl_unec2.room.sign_in_up.db.MyDatabase
import com.example.atl_unec2.room.sign_in_up.model.Person
import com.example.atl_unec2.room.sign_in_up.db.SignUpInDao
import kotlinx.coroutines.flow.Flow

class LocalRepository(context: Context) {

    private val db: SignUpInDao? = MyDatabase.getInstance(context)?.personDao()

     fun getAllPerson(): Flow<List<Person>>? = db?.getAllPersons()

    suspend fun getPerson(name: String, password: String): Person? {
        return db?.findPersonByID(name, password)
    }

    fun insertPerson(person: Person) {
        db?.insertPerson(person)
    }

}