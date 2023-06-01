package com.example.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usersData")
data class UsersData(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val name:String,
    val contact:String
)