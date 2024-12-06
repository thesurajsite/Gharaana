package com.gharaana.Authentication.UserSignup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.gharaana.R

@Composable
fun UserSignupDetailsScreen(navController: NavController){

    val signupService = RetrofitInstance.signupService

    // Create the ViewModel using the ViewModelFactory
    val viewModel: SignupViewModel = viewModel(factory = SignupViewModelFactory(signupService))


    val signupState by viewModel.signupState.collectAsState()


    Scaffold(modifier = Modifier.fillMaxSize())
    {
        padding->

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(padding)
            .background(colorResource(R.color.orange)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .size(200.dp)
            )

            Spacer(Modifier.height(30.dp))

            Text(text = "Gharaana Signup",
                color = Color.White,
                fontSize = 30.sp
            )

            Spacer(Modifier.height(30.dp))

            TextField(
                value = signupState.customerName!!,
                onValueChange = {viewModel.updateCustomerName(it)},
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(50.dp)
                    .background(colorResource(R.color.orange))
                    .clip(RoundedCornerShape(8.dp)),
                label = { Text("Name") }
            )

            Spacer(Modifier.height(30.dp))

            TextField(
                value = signupState.phoneNo,
                onValueChange = {viewModel.updatePhoneNo(it)},
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(50.dp)
                    .background(colorResource(R.color.orange))
                    .clip(RoundedCornerShape(8.dp)),
                label = { Text("Phone Number") }
            )

            Spacer(Modifier.height(30.dp))

            Button(
                onClick = {
                    viewModel.signupWithOTP()
                },
                enabled = !signupState.isLoading!!,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green
                )
            ) {
                Text("Signup With OTP")
            }

            signupState.error?.let {
                Text(it, color = Color.Black)
            }

            LaunchedEffect(signupState.isOtpSent) {
                if(signupState.isOtpSent!!){
                    navController.navigate("home")
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