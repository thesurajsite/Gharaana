package com.gharaana.Authentication.UserSignup

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gharaana.Retrofit.RetrofitService
import com.gharaana.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignupViewModel(private val retrofitService: RetrofitService): ViewModel() {

    private lateinit var sharedPreferences: SharedPreferences

    private val _signupState = MutableStateFlow(SignupState())
    val signupState : StateFlow<SignupState> = _signupState.asStateFlow()

    private val _signupVerifyState = MutableStateFlow(SignupVerifyState())
    val signupVerifyState : StateFlow<SignupVerifyState> = _signupVerifyState.asStateFlow()

    fun updatePhoneNo(phoneNo: String){
        _signupState.update { it.copy(phoneNo = phoneNo) }    // From Signup DataClass
    }

    fun updateCustomerName(customerName: String){
        _signupState.update { it.copy(customerName = customerName) }  // From Signup DataClass
    }

    fun updateAccountCreated(boolean: Boolean){
        _signupState.update { it.copy(accountCreated = boolean) }
    }

    fun updateOtp(otp: String){
        _signupVerifyState.update { it.copy( otp = otp) }  // From SignupVerify DataClass
    }

    fun signupWithOTP(){
        viewModelScope.launch {

            // TO BE EDITED LATER ON, Remove the HardCoded email and Address
            _signupState.update { it.copy(
                email = "thesurajsite@gmail.com",
                location = "BANGALORE"
            ) }

            val currentState = _signupState.value

            if(currentState.phoneNo.isEmpty() || currentState.customerName!!.isEmpty()){
             _signupState.update { it.copy(message ="Please Fill All Details") }
                return@launch
            }

            _signupState.update { it.copy(isLoading = true) }


            try {
                val request = SignupRequestDataClass(customerName = currentState.customerName, phoneNo = currentState.phoneNo, email = currentState.email, location = currentState.location )
                val response = retrofitService.signupWithOtp(request)

                if(response.isSuccessful){
                    val signupResponse = response.body()
                    _signupState.update {
                        it.copy(
                            accountCreated = signupResponse?.accountCreated?:false,
                            isLoading = false,
                            message = signupResponse!!.response
                        )
                    }
                    Log.d("SignupAPI","${signupResponse}")
                }
                else{
                    _signupState.update {
                        it.copy(
                        accountCreated = false,
                        isLoading = false,
                        message = "Signup Failed"
                    ) }
                }
            }
            catch(e: Exception){
                _signupState.update {
                    it.copy(
                        accountCreated = false,
                        isLoading = false,
                        message = "Some Error Occured"
                    )
                }
                Log.d("SignupAPI",e.localizedMessage!!)
            }
        }
    }


    fun signupVerify(context: Context){

        sharedPreferences = SharedPreferences(context)
        //val currentState2 = _signupState.value
        //Log.d("SignupVerify", "${currentState2.customerName}, ${currentState2.phoneNo}, ${currentState2.email}, ${currentState2.location}, ${currentState2.location}")

        viewModelScope.launch {

            // Copied the customer Data from Previous state
            _signupVerifyState.update {
                it.copy(
                    phoneNo = _signupState.value.phoneNo,
                    customerName = _signupState.value.customerName,
                    email = _signupState.value.email,
                    location = _signupState.value.location
                )
            }

            val currentState = _signupVerifyState.value

            if(currentState.otp!!.isEmpty()){
                _signupVerifyState.update { it.copy(message = "Please Enter OTP") }
                return@launch
            }

            _signupVerifyState.update { it.copy(isLoading = true) }

            //Log.d("SignupVerify", "${currentState.customerName}, ${currentState.phoneNo}, ${currentState.email}, ${currentState.location}, ${currentState.otp}")

            try {
                val request = SignupVerifyRequest(
                    customerName = currentState.customerName!!,
                    phoneNo = currentState.phoneNo,
                    email = currentState.email,
                    location = currentState.location,
                    otp = currentState.otp
                )
                val response = retrofitService.signupVerify(request)

                if(response.isSuccessful){
                    val verifyResponse = response.body()
                    _signupVerifyState.update {
                        it.copy(
                            isLoading = false,
                            token = verifyResponse!!.token,
                            action = verifyResponse.action
                        )
                    }
                    Log.d("SignupVerify", "$verifyResponse")

                    // action response can be true or false based on that frame the message
                    if(_signupVerifyState.value.action == true){
                        // update token
                        sharedPreferences.updateUserToken(_signupVerifyState.value.token!!)
                        _signupVerifyState.update { it.copy(message = "Verification completed") }
                    }
                    else{
                        _signupVerifyState.update { it.copy(message = "Incorrect OTP") }
                    }


                } else{
                    _signupVerifyState.update {
                        it.copy(
                            isLoading = false,
                            action = false,
                            message = "Some Error Occured"
                        )
                    }
                    Log.d("SignupVerify", "Some Error Occured")

                }

            }
            catch (e: Exception){
                _signupVerifyState.update {
                    it.copy(
                        isLoading = false,
                        action = false,
                        message = "Some Error Occured"
                    )
                }
                Log.d("SignupVerify", e.localizedMessage!!)
            }

        }


    }
}