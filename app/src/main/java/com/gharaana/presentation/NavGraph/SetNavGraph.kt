package com.gharaana.presentation.NavGraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gharaana.presentation.components.BottomNavScreen

@Composable
fun SetNavGraph(){
 val navController: NavHostController = rememberNavController()

 NavHost(navController = navController, startDestination = Routes.BottomNavScreen.routes) {

     composable(route = "bottom_nav_screen"){
         BottomNavScreen(navController)
     }

 }

}