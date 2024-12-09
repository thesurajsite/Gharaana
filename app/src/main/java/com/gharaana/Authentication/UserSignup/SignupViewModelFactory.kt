package com.gharaana.Authentication.UserSignup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignupViewModelFactory(private val signupService: SignupService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignupViewModel::class.java)) {
            return SignupViewModel(signupService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
