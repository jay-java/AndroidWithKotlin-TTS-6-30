package com.example.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UsersData::class], version = 1)
abstract class UserDatabase:RoomDatabase() {

    abstract fun userDao():UsersDao

}