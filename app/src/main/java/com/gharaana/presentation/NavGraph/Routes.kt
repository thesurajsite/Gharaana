package com.gharaana.presentation.NavGraph

sealed class Routes(val routes: String) {

    object Home : Routes("home")
    object Inbox : Routes("inbox")
    object Star : Routes("star")
    object ShoppingCart : Routes("shopping_cart")
    object Profile :Routes("profile")
    object BottomNavScreen:Routes("bottom_nav_screen")

}