package com.codingwithmatt.authenticationapp.data

import com.codingwithmatt.authenticationapp.data.dao.UserDao
import com.codingwithmatt.authenticationapp.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepo internal constructor(private val userDao: UserDao){
    fun fetchSelf() = userDao.fetchSelf

    suspend fun insertUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.insertUser(user)
        }
    }

    suspend fun deleteUser(user: User) {
        withContext(Dispatchers.IO) {
            userDao.deleteUser(user)
        }
    }

    companion object {

        @Volatile
        private var instance: UserRepo? = null

        fun getInstance(userDao: UserDao) =
            instance ?: synchronized(this) {
                instance
                    ?: UserRepo(userDao).also { instance = it }
            }
    }

}