package com.gharaana.Authentication.UserLogin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gharaana.Retrofit.RetrofitService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val retrofitService: RetrofitService): ViewModel() {

    private val _loginState = MutableStateFlow(LoginState())
    val loginState : StateFlow<LoginState> = _loginState.asStateFlow()

    fun updatePhoneNo(phoneNo:String){
        _loginState.update { it.copy(phoneNo = phoneNo) }
    }

    fun updateAction(action:Boolean){
        _loginState.update { it.copy(action = action) }
    }

    fun loginWithOtp(){
        viewModelScope.launch {

            val currentState = _loginState.value
            if(currentState.phoneNo!!.isEmpty()){
                _loginState.update { it.copy(message = "Please fill the Phone Number") }
                return@launch
            }

            _loginState.update { it.copy(isLoading = true) }

            try {
                val request = LoginRequest(phoneNo = currentState.phoneNo)
                val response = retrofitService.loginWithOtp(request)

                if(response.isSuccessful){
                    val loginResposne = response.body()
                    _loginState.update {
                        it.copy(
                            isLoading = false,
                            action = loginResposne!!.action
                        )
                    }

                    // Based on Action Response (True/False), If OTP is sent or not
                    if(loginResposne!!.action == true){
                        _loginState.update { it.copy(message = "OTP Sent") }
                    }
                    else{
                        _loginState.update { it.copy(message = "Incorrect OTP") }
                    }

                    Log.d("LoginAPI","${loginResposne}")

                }
                else{
                    _loginState.update {
                        it.copy(
                            isLoading = false,
                            action = false,
                            message = "Some Error Occured"
                        )
                    }
                }

            }catch(e:Exception){
                _loginState.update {
                    it.copy(
                        isLoading = false,
                        action = false,
                        message = "Some Error Occured"
                    )
                }
                Log.d("LoginAPI",e.localizedMessage!!)
            }

        }
    }


}