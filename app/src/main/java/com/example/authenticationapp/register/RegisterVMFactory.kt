package com.example.authenticationapp.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.authenticationapp.data.UserRepo
import com.example.authenticationapp.login.LoginViewModel

class RegisterVMFactory(private val userRepo: UserRepo): ViewModelProvider.NewInstanceFactory()  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RegisterViewModel(userRepo) as T
    }
}
