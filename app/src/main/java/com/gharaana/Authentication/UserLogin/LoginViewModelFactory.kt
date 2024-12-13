package com.gharaana.Authentication.UserLogin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gharaana.Authentication.UserSignup.SignupViewModel
import com.gharaana.Retrofit.RetrofitService

class LoginViewModelFactory(private val retrofitService: RetrofitService): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(retrofitService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}