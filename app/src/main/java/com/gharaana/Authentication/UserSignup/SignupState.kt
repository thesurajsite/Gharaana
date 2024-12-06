package com.gharaana.Authentication.UserSignup

data class SignupState(

    val customerName: String?="",
    val phoneNo: String="",
    val email: String?="",
    val location: String?="",
    val isLoading: Boolean?=false,
    val isOtpSent: Boolean?=false,
    val error: String?=""
)
