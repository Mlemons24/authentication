package com.example.authenticationapp.forgot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.authenticationapp.data.UserRepo


class ForgotVMFactory(private val userRepo: UserRepo): ViewModelProvider.NewInstanceFactory()  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ForgotPasswordViewModel(userRepo) as T
    }
}