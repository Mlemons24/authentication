package com.codingwithmatt.authenticationapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codingwithmatt.authenticationapp.data.model.User

@Dao
interface UserDao {
    @get:Query("SELECT * FROM users")
    val fetchSelf: LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)
}

