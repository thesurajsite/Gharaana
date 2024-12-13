package com.gharaana.Authentication.UserSignup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gharaana.Retrofit.RetrofitService

class SignupViewModelFactory(private val retrofitService: RetrofitService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignupViewModel::class.java)) {
            return SignupViewModel(retrofitService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
