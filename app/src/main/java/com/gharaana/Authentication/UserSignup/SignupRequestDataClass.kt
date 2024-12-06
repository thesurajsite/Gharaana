package com.gharaana.Authentication.UserSignup

data class SignupDataRequestClass(
    val customerName:String,
    val phoneNo: String,
    val email: String?="",
    val location: String?=""
)
