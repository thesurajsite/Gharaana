package com.gharaana.Authentication.UserSignup

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupService {

    @POST("customer/signup")
    suspend fun signupWithOtp(
        @Body customerSignUpRequest: SignupDataRequestClass
    ): Response<SignupResponseDataClass>

}