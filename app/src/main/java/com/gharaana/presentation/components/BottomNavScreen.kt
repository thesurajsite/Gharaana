package com.gharaana.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gharaana.Utils.ItemsList
import com.gharaana.presentation.Inbox.Inbox
import com.gharaana.presentation.NavGraph.Routes
import com.gharaana.presentation.ShoppingCart.ShoppingCart
import com.gharaana.presentation.profile.ProfileScreen
import com.gharaana.R
import com.gharaana.ui.Screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun BottomNavScreen(navController: NavController) {

    val navController = rememberNavController()
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.Transparent,
                cutoutShape = RoundedCornerShape(50),
                content = {
                    BottomNavigation {
                        BottomNavBar(tabBarItems = ItemsList.TabBarItems, navController)

                    }
                },

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                    openDialog.value = true

                },
                shape = RoundedCornerShape(50),
            ) {
                Icon(Icons.Filled.Add, tint = Color.White, contentDescription = "Add")
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(15.dp)
        ) {


            FloatAlertDialog(openDialog = openDialog)
        }
        NavHost(
            navController = navController,
            startDestination = Routes.Home.routes,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Routes.Home.routes) {
                HomeScreen()
            }
            composable(route = Routes.Inbox.routes) {
                Inbox()
            }
            composable(route = Routes.ShoppingCart.routes) {
                ShoppingCart()
            }
            composable(route = Routes.Profile.routes) {
                ProfileScreen()
            }
        }
    }
}