package com.gharaana.Authentication.UserSignup

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://your-api-base-url.com/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) // Add your converter here (Gson, Moshi, etc.)
        .build()

    val signupService: SignupService = retrofit.create(SignupService::class.java)
}
