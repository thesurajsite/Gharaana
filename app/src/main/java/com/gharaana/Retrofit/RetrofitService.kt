package com.gharaana.Retrofit

import com.gharaana.Authentication.UserSignup.SignupRequestDataClass
import com.gharaana.Authentication.UserSignup.SignupResponseDataClass
import com.gharaana.Authentication.UserSignup.SignupVerifyRequest
import com.gharaana.Authentication.UserSignup.SignupVerifyResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @POST("customer/signup")
    suspend fun signupWithOtp(
        @Body customerSignUpRequest: SignupRequestDataClass
    ): Response<SignupResponseDataClass>

    @POST("customer/signup/verify")
    suspend fun signupVerify(
        @Body customerSignupVerify : SignupVerifyRequest
    ) : Response<SignupVerifyResponse>

}