package com.example.atl_unec2.room.lesson

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "first_Name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)