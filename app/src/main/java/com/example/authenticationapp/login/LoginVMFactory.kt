package com.example.authenticationapp.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.authenticationapp.data.UserRepo

class LoginVMFactory(private val userRepo: UserRepo) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(userRepo) as T
    }
}