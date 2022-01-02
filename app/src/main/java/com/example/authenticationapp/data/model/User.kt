package com.example.authenticationapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey @ColumnInfo(name = "_id") val _id: String,
    val email: String,
    val authToken: String?
)
