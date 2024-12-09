package com.gharaana.Authentication.UserSignup

data class SignupVerifyState(

    val customerName: String?="",   // Request
    val phoneNo: String="",         // Request
    val email: String?="",          // Request
    val location: String?="",       // Request
    val otp: String?="",            // Request
    val isLoading: Boolean?=false,             // Loading
    val message: String?="",                   // Loading
    val action: Boolean?=false,      // Response
    val token: String?=""           // Response

)
