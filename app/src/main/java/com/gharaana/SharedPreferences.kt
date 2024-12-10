package com.gharaana

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(private val context: Context): MyInterface {

    fun getSharedPreferences(s: String, modePrivate: Int): SharedPreferences {
        return context.getSharedPreferences(s, modePrivate)
    }

    override fun getUserToken(): String? {
        val pref: SharedPreferences = getSharedPreferences("GHARAANA", Context.MODE_PRIVATE)
        return pref.getString("userToken", "")
    }

    override fun updateUserToken(token: String){
        val pref : SharedPreferences =  getSharedPreferences("GHARAANA", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("userToken", "token")
        editor.apply()
    }
}