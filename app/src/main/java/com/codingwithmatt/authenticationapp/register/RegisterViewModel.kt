package com.codingwithmatt.authenticationapp.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmatt.authenticationapp.data.UserRepo
import com.codingwithmatt.authenticationapp.data.service.AuthService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel internal constructor(userRepo: UserRepo) : ViewModel() {

    val authService : AuthService=AuthService.AuthServiceCreator.newService()

    fun registerUser(email: String, firstname: String, lastname: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val response = authService.registerNewUser(lastname, firstname, email, password)
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