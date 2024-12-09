package com.gharaana.Authentication.UserSignup

data class SignupVerifyRequest(
    val customerName:String,
    val phoneNo: String,
    val email: String?="",
    val location: String?="",
    val otp: String?=""
)

data class SignupVerifyResponse(
    val action: Boolean,
    val token: String?=""
)
