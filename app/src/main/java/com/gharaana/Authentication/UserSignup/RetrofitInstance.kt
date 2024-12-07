package com.gharaana.Authentication.UserSignup

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.net.ssl.SSLContext

object RetrofitInstance {

    private const val BASE_URL = "https://gharaanamvp.onrender.com/"


    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) // Add your converter here (Gson, Moshi, etc.)
        .build()

    val signupService: SignupService = retrofit.create(SignupService::class.java)
}
