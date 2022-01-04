package com.codingwithmatt.authenticationapp

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.codingwithmatt.authenticationapp.data.UserRepo
import com.codingwithmatt.authenticationapp.forgot.ForgotPasswordViewModel
import com.codingwithmatt.authenticationapp.login.LoginViewModel
import com.codingwithmatt.authenticationapp.register.RegisterViewModel


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