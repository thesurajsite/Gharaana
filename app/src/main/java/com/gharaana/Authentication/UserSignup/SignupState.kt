package com.gharaana.Authentication.UserSignup

data class SignupState(

    val customerName: String?="",
    val phoneNo: String="",
    val email: String?="",
    val location: String?="",
    val isLoading: Boolean?=false,
    val accountCreated: Boolean?=false,
    val message: String?=""
)
