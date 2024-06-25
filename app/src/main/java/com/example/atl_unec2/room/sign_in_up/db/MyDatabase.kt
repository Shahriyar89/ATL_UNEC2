package com.example.atl_unec2.room.sign_in_up.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.atl_unec2.room.lesson.CustomRoomDao
import com.example.atl_unec2.room.lesson.User
import com.example.atl_unec2.room.sign_in_up.model.Person


@Database(entities = [User::class, Person::class], version = 1)
abstract class MyDatabase:RoomDatabase() {
    abstract fun userDao(): CustomRoomDao

    abstract fun personDao(): SignUpInDao


    companion object {

        private var INSTANCE: MyDatabase? = null
//        var migration1_2: Migration = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("Alter Table customers Add Column phone Text Default ''")
//            }


        fun getInstance(context: Context): MyDatabase? {
            if (INSTANCE == null) {
                synchronized(MyDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java, "local2.db"
                    ).allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }


}