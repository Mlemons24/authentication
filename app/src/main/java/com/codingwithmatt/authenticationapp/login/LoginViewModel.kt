package com.codingwithmatt.authenticationapp.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmatt.authenticationapp.data.UserRepo
import com.codingwithmatt.authenticationapp.data.service.AuthService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel internal constructor(private val userRepo: UserRepo) : ViewModel() {

    val authService: AuthService = AuthService.AuthServiceCreator.newService()
    val user = userRepo.fetchSelf()
    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = authService.login(email, password)
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d("user", "user= $it.email")
                    userRepo.insertUser(it)
                }
            } else {
                // TODO handle error state

            }

        }
    }


}