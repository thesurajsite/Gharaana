package com.gharaana.Utils

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AllInbox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AllInbox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gharaana.R
import com.gharaana.presentation.Models.BottomNavModel
import com.gharaana.presentation.NavGraph.Routes

object ItemsList {

    val HomeTab = BottomNavModel(
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        routes = Routes.Home.routes,
        Modifier.padding(1.dp)

    )
    val Inbox = BottomNavModel(
        selectedIcon = Icons.Filled.AllInbox,
        unselectedIcon = Icons.Outlined.AllInbox,
        routes = Routes.Inbox.routes,
        Modifier.padding(end = 30.dp)
    )
    val ShoppingCart = BottomNavModel(
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
        routes = Routes.ShoppingCart.routes,
        Modifier.padding(start = 30.dp)
    )
    val Profile = BottomNavModel(
        selectedIcon = Icons.Filled.AccountBox,
        unselectedIcon = Icons.Outlined.AccountBox,
        routes = Routes.Profile.routes,
        Modifier.padding(1.dp)
    )

    val TabBarItems = listOf(HomeTab, Inbox, ShoppingCart, Profile)

//    val images = listOf(
//        R.drawable.a,
//        R.drawable.b,
//        R.drawable.c,
//        R.drawable.d,
//        R.drawable.e,
//    )
}