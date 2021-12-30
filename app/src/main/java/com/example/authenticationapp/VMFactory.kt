package com.example.authenticationapp

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.example.authenticationapp.data.UserRepo
import com.example.authenticationapp.forgot.ForgotPasswordViewModel
import com.example.authenticationapp.login.LoginViewModel
import com.example.authenticationapp.register.RegisterViewModel


class VMFactory(private val userRepo: UserRepo) : ViewModelProvider.NewInstanceFactory()  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == LoginViewModel::class.java) {
            LoginViewModel(userRepo) as T
        } else if (modelClass == RegisterViewModel::class.java) {
            RegisterViewModel(userRepo) as T
        } else if (modelClass == ForgotPasswordViewModel::class.java) {
            ForgotPasswordViewModel(userRepo) as T
        } else {
            super.create(modelClass)
        }
    }


}