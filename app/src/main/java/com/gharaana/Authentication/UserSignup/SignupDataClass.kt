package com.gharaana.Authentication.UserSignup

data class SignupRequestDataClass(
    val customerName:String,
    val phoneNo: String,
    val email: String?="",
    val location: String?=""
)

data class SignupResponseDataClass(
    val response: String,
    val accountCreated: Boolean
)
