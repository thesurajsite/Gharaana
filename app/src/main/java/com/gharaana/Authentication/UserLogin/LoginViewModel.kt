package com.gharaana.Authentication.UserLogin

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gharaana.Authentication.UserSignup.SignupVerifyRequest
import com.gharaana.Retrofit.RetrofitService
import com.gharaana.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(private val retrofitService: RetrofitService): ViewModel() {

    private lateinit var sharedPreferences: SharedPreferences

    private val _loginState = MutableStateFlow(LoginState())
    val loginState : StateFlow<LoginState> = _loginState.asStateFlow()

    private val _loginVerifyState = MutableStateFlow(LoginVerifyState())
    val loginVerifyState : StateFlow<LoginVerifyState> = _loginVerifyState

    fun updatePhoneNo(phoneNo:String){
        _loginState.update { it.copy(phoneNo = phoneNo) }
    }

    fun updateAction(action:Boolean){
        _loginState.update { it.copy(action = action) }
    }

    fun updateOtp(otp:String){
        _loginVerifyState.update { it.copy(otp = otp) }
    }

    fun updateLoginVerifyStatus(status: Boolean){
        _loginVerifyState.update { it.copy(status = status) }
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

    fun loginVerify(context: Context){

        sharedPreferences = SharedPreferences(context)

        viewModelScope.launch {

            // Copied the Phone Number from Previous state
            _loginVerifyState.update { it.copy(phoneNo = _loginState.value.phoneNo) }

            val currentState = _loginVerifyState.value

            if(currentState.otp!!.isEmpty()){
                _loginVerifyState.update { it.copy(message = "Please Enter OTP") }
                return@launch
            }

            _loginVerifyState.update { it.copy(isLoading = true) }

            try {
                val request = LoginVerifyRequest(
                    phoneNo = currentState.phoneNo,
                    otp = currentState.otp
                )

                val response = retrofitService.loginVerify(request)

                if(response.isSuccessful){
                    val verifyResponse = response.body()
                    _loginVerifyState.update {
                        it.copy(
                            isLoading = false,
                            token = verifyResponse!!.token,
                            status = verifyResponse.status
                        )
                    }

                    Log.d("LoginVerify", "$verifyResponse")

                    // action response can be true or false based on that frame the message
                    if(_loginVerifyState.value.status == true){
                        // update token
                        sharedPreferences.updateUserToken(_loginVerifyState.value.token!!)
                        _loginVerifyState.update { it.copy(message = "Verification completed") }
                    }
                    else{
                        _loginVerifyState.update { it.copy(message = "Incorrect OTP") }
                    }


                } else{
                    _loginVerifyState.update {
                        it.copy(
                            isLoading = false,
                            status = false,
                            message = "Some Error Occured"
                        )
                    }
                    Log.d("LoginVerify", "Some Error Occured")

                }

            }
            catch (e: Exception){
                _loginVerifyState.update {
                    it.copy(
                        isLoading = false,
                        status = false,
                        message = "Some Error Occured"
                    )
                }
                Log.d("LoginVerify", e.localizedMessage!!)
            }


        }
    }


}