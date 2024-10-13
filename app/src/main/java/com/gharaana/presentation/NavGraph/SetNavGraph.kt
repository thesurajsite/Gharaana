package com.gharaana.presentation.NavGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gharaana.presentation.Inbox.Inbox
import com.gharaana.presentation.ShoppingCart.ShoppingCart
import com.gharaana.presentation.components.BottomNavScreen
import com.gharaana.presentation.profile.ProfileScreen

@Composable
fun SetNavGraph(){
 val navController: NavHostController = rememberNavController()

 NavHost(navController = navController, startDestination = Routes.BottomNavScreen.routes) {

     composable(route = "bottom_nav_screen"){
         BottomNavScreen(navController)
     }
//     composable(route = Routes.Home.routes){
//
//      HomeScreen(navController)
//     }
//
//     composable(route = Routes.Inbox.routes){
//         Inbox()
//     }
//     composable(route = Routes.ShoppingCart.routes){
//         ShoppingCart()
//     }
//     composable(route = Routes.Profile.routes){
//         ProfileScreen()
//     }
 }
}