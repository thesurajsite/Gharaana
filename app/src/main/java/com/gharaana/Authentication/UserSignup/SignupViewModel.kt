package com.gharaana.Authentication.UserSignup

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.sign

class SignupViewModel(private val signupService: SignupService): ViewModel() {

    private val _signupState = MutableStateFlow(SignupState())
    val signupState : StateFlow<SignupState> = _signupState.asStateFlow()

    fun updatePhoneNo(phoneNo: String){
        _signupState.update { it.copy(phoneNo = phoneNo) }
    }

    fun updateCustomerName(customerName: String){
        _signupState.update { it.copy(customerName = customerName) }
    }

    fun signupWithOTP(){
        viewModelScope.launch {
            val currentState = _signupState.value

            if(currentState.phoneNo.isEmpty() || currentState.customerName!!.isEmpty()){
             _signupState.update { it.copy(message ="Please Fill All Details") }
                return@launch
            }

            _signupState.update { it.copy(isLoading = true) }

            try {
                val request = SignupDataRequestClass(customerName = currentState.customerName, phoneNo = currentState.phoneNo, email = "thesurajsite@gmail.com", location = "BANGALORE" )
                val response = signupService.signupWithOtp(request)

                if(response.isSuccessful){
                    val signupResponse = response.body()
                    _signupState.update {
                        it.copy(
                            isOtpSent = signupResponse?.accountCreated?:false,
                            isLoading = false,
                            message = signupResponse!!.response
                        )
                    }
                    Log.d("apicall","${signupResponse}")
                }
                else{
                    _signupState.update {
                        it.copy(
                        isOtpSent = false,
                        isLoading = false,
                        message = "Signup Failed"
                    ) }
                }
            }
            catch(e: Exception){
                _signupState.update {
                    it.copy(
                        isOtpSent = false,
                        isLoading = false,
                        message = "Some Error Occured"
                    )
                }
                Log.d("SignAPI",e.localizedMessage!!)
            }
        }
    }
}