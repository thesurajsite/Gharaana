package com.gharaana.Authentication.UserSignup

import android.widget.Toast
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gharaana.R

@Composable
fun SignupVerifyScreen(navController: NavController, viewModel: SignupViewModel){

val signupVerifyState by viewModel.signupVerifyState.collectAsState()
    val context = LocalContext.current

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
                painter = painterResource(R.drawable.otp),
                contentDescription = "logo",
                modifier = Modifier
                    .size(300.dp)
            )

            Spacer(Modifier.height(30.dp))

            Text(text = "Please Enter OTP",
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(10.dp))

            OutlinedTextField(
                value = signupVerifyState.otp!!,
                onValueChange = { viewModel.updateOtp(it) },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(60.dp),
                label = { Text("Enter Verification Code") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                textStyle = TextStyle(
                    fontSize = 20.sp
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                singleLine = true
            )

            Spacer(Modifier.height(10.dp))

            Button(
                onClick = {
                    viewModel.signupVerify(context)
                },
                enabled = !signupVerifyState.isLoading!!,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RectangleShape,
            ) {
                Text("Verify", fontSize = 20.sp, color = Color.White)
            }

            Spacer(Modifier.height(30.dp))

            signupVerifyState.message?.let {
                Text(it, color = Color.Red, fontSize = 20.sp)
            }

            val context = LocalContext.current
            if(signupVerifyState.action==true){
                Toast.makeText(context, "Verification Successful", Toast.LENGTH_SHORT).show()
                navController.navigate("home")
            }

        }

    }


}

//@Preview(showBackground = true)
//@Composable
//fun UserSignupPreview(){
//    UserSignupDetailsScreen()
//}