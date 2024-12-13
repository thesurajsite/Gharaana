package com.gharaana.presentation.NavGraph

import okhttp3.Route

sealed class Routes(val routes: String) {

    object Home : Routes("home")
    object Inbox : Routes("inbox")
    object Star : Routes("star")
    object ShoppingCart : Routes("shopping_cart")
    object Profile :Routes("profile")
    object BottomNavScreen:Routes("bottom_nav_screen")

    object SignupScreen:Routes("signup_screen")
    object SignupVerifyScreen: Routes("signup_verify")
    object LoginScreen: Routes("login_screen")

}