package com.gharaana.Authentication.UserLogin

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.gharaana.presentation.NavGraph.Routes

@Composable
fun LoginScreen(navController: NavController){

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

            Text(text = "Gharaana Login",
                color = Color.Black,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )


            Spacer(Modifier.height(10.dp))

            OutlinedTextField(
                value = "",
                onValueChange = { "" },
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
                    // OnClick Listener
                },
                //enabled = !signupState.isLoading!!,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                shape = RectangleShape,
            ) {
                Text("Get Verification Code", fontSize = 20.sp)
            }


            Spacer(Modifier.height(30.dp))

            //            signupState.message?.let {
//                Text(it, color = Color.Red, fontSize = 20.sp)
//            }

            Spacer(Modifier.height(10.dp))

            TextButton(
                onClick = {
                    navController.navigate(Routes.SignupScreen.routes)
                }
            ) {
                Text("Don't Have an Account? Signup Here", color = Color.Black)
            }



//            val context = LocalContext.current
//            LaunchedEffect(signupState.accountCreated) {
//                if(signupState.accountCreated!!){
//                    viewModel.updateAccountCreated(false)
//                    Toast.makeText(context, "OTP Sent", Toast.LENGTH_SHORT).show()
//                    navController.navigate("signup_verify")
//                }
//            }

        }

    }

}