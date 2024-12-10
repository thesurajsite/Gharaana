package com.gharaana.presentation.profile

import android.content.Context
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gharaana.MyInterface
import com.gharaana.SharedPreferences
import com.gharaana.presentation.NavGraph.Routes


@Composable
fun ProfileScreen(navController: NavController) {

    val context = LocalContext.current
    val sharedPreferences = SharedPreferences(context)
    val token = sharedPreferences.getUserToken()

    if(token!!.isEmpty()){
        navController.navigate(Routes.UserSignupDetailsScreen.routes)
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
                sharedPreferences.updateUserToken("")
                navController.navigate(Routes.Home.routes)
            },
            modifier = Modifier.fillMaxWidth(0.9f).height(60.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Color.Red)
        ){
            Text("LOGOUT", fontSize = 20.sp)
        }
    }



}



