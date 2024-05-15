package com.example.atl_unec2.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface CustomRoomDao {

    @Query("SELECT * FROM user")
    fun getAllUser(): List<User>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg users: User)


    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>


    @Query("SELECT * FROM user WHERE first_name LIKE :first")
    fun findByName(first: String): List<User>


    @Delete
    fun delete(user: User)


    @Update
    fun updateUser(user: User)


    @Query("SELECT * FROM user WHERE uid=:id")
    fun findById(id: Int): User

}