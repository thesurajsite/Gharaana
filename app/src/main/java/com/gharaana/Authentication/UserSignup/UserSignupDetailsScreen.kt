package com.gharaana.Authentication.UserSignup

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.gharaana.R
import com.gharaana.presentation.NavGraph.Routes

@Composable
fun UserSignupDetailsScreen(navController: NavController, viewModel: SignupViewModel){

//    val signupService = RetrofitInstance.signupService
//    // Created the ViewModel using the ViewModelFactory
//    val viewModel: SignupViewModel = viewModel(factory = SignupViewModelFactory(signupService))
    val signupState by viewModel.signupState.collectAsState()


    Scaffold(modifier = Modifier.fillMaxSize())
    {
        padding->


        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(padding)
            .background(colorResource(R.color.white)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(R.drawable.logo2),
                contentDescription = "logo",
                modifier = Modifier
                    .size(300.dp)
            )

            Spacer(Modifier.height(30.dp))

            Text(text = "Gharaana Signup",
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(10.dp))

            OutlinedTextField(
                value = signupState.customerName!!,
                onValueChange = { viewModel.updateCustomerName(it) },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(60.dp),
                label = { Text("Name") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black, // White when not focused
                    focusedBorderColor = Color.Black, // Primary color when focused
                    focusedLabelColor = Color.Black, // Label color when focused
                    unfocusedLabelColor = Color.Black, // Label color when not focused
                    focusedTextColor = Color.Black, // Text color when focused
                    unfocusedTextColor = Color.Black  // Text color when not focused
                ),
                textStyle = TextStyle(
                    fontSize = 20.sp
                ),
                singleLine = true
            )


            Spacer(Modifier.height(10.dp))

            OutlinedTextField(
                value = signupState.phoneNo,
                onValueChange = { viewModel.updatePhoneNo(it) },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(60.dp),
                label = { Text("Phone Number") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                textStyle = TextStyle(
                    fontSize = 20.sp,
                ), keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                singleLine = true
            )

            Spacer(Modifier.height(10.dp))

            Button(
                onClick = {
                    viewModel.signupWithOTP()
                },
                enabled = !signupState.isLoading!!,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RectangleShape,
            ) {
                Text("Get Verification Code", fontSize = 20.sp)
            }


            Spacer(Modifier.height(30.dp))


            signupState.message?.let {
                Text(it, color = Color.Red, fontSize = 20.sp)
            }

            val context = LocalContext.current
            LaunchedEffect(signupState.accountCreated) {
                if(signupState.accountCreated!!){
                    Toast.makeText(context, "OTP Sent", Toast.LENGTH_SHORT).show()
                    navController.navigate("signup_verify")
                }
            }

        }

    }

}

//@Preview(showBackground = true)
//@Composable
//fun UserSignupPreview(){
//    UserSignupDetailsScreen()
//}