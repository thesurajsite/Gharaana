package com.gharaana.Retrofit

import com.gharaana.Authentication.UserLogin.LoginRequest
import com.gharaana.Authentication.UserLogin.LoginResponse
import com.gharaana.Authentication.UserLogin.LoginVerifyRequest
import com.gharaana.Authentication.UserLogin.LoginVerifyResponse
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


    @POST("user/otp")
    suspend fun loginWithOtp(
        @Body customerLoginRequest : LoginRequest
    ) : Response<LoginResponse>


    @POST("user/login")
    suspend fun loginVerify(
        @Body customerLoginVerify : LoginVerifyRequest
    ) : Response<LoginVerifyResponse>


}