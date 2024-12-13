package com.gharaana.Authentication.UserLogin

data class LoginState(
    val phoneNo:String?="",
    val isLoading:Boolean?=false,
    val message:String?="",
    val action:Boolean?=false
)

data class LoginVerifyState(
    val phoneNo:String?="",
    val otp:String?="",
    val isLoading:Boolean?=false,
    val message:String?="",
    val token:String?="",
    val response:String?="",
    val status:Boolean?=false
)