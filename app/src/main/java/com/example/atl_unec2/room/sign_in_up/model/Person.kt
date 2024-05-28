package com.example.atl_unec2.room.sign_in_up.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "person")
data class Person(
    @PrimaryKey(autoGenerate = true) val uid: Int=0 ,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo(name = "imageUrl") val imageUrl: String?=null,
)