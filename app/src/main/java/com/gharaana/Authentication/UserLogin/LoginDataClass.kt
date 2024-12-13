package com.gharaana.Authentication.UserLogin

data class LoginRequest(
    val phoneNo:String?=""
)

data class LoginResponse(
    val action:Boolean?=false
)

data class LoginVerifyRequest(
    val phoneNo:String?="",
    val otp:String?=""
)

data class LoginVerifyResponse(
    val token:String?="",
    val response:String?="",
    val status:Boolean?=false
)
