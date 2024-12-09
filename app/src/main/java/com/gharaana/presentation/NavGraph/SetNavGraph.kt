package com.gharaana.presentation.NavGraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gharaana.Authentication.UserSignup.SignupVerifyScreen
import com.gharaana.Authentication.UserSignup.SignupViewModel
import com.gharaana.Authentication.UserSignup.UserSignupDetailsScreen
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

     composable(route = "user_signup_detail"){
         val signupViewModel: SignupViewModel = viewModel()
         UserSignupDetailsScreen(navController)
     }

//     composable(route= Routes.SignupVerifyScreen.routes){
//        SignupVerifyScreen()
//     }





 }

}