package com.example.authenticationapp.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authenticationapp.data.UserRepo
import com.example.authenticationapp.data.service.AuthService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel internal constructor(userRepo: UserRepo) : ViewModel() {

    val authService : AuthService = AuthService.AuthServiceCreator.newService()

    fun login(email: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val response = authService.login( email, password)
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d("user","user= $it.email")

                }
            } else {
                    // TODO handle error state

            }

        }
    }






}