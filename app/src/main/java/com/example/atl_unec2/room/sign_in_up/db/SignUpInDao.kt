package com.example.atl_unec2.room.sign_in_up.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.atl_unec2.room.sign_in_up.model.Person


@Dao
interface SignUpInDao {
    @Query("SELECT * FROM person")
    fun getAllPersons(): List<Person>

    @Insert
    fun insertPerson(person: Person)

    @Query("SELECT * FROM person WHERE name=:name and password=:password")
    fun findPersonByID(name: String,password:String): Person?

    @Delete
    fun delete(user: Person)




}