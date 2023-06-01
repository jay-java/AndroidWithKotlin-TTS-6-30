package com.example.roomdatabase

import android.service.autofill.UserData
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsersDao {
    @Insert
    suspend fun insertUser(user:UsersData)
    @Update
    suspend fun updateUser(user:UsersData)
    @Delete
    suspend fun deleteUser(user:UsersData)
    @Query("SELECT * FROM usersData")
    fun getAllUsers() : LiveData<List<UsersData>>
}
