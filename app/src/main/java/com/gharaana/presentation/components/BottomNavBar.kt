package com.gharaana.presentation.components


import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.gharaana.presentation.Models.BottomNavModel
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gharaana.R

@Composable
fun BottomNavBar(tabBarItems :List<BottomNavModel>, navController: NavController){
    BottomNavigation(backgroundColor = colorResource(id = R.color.light_grey)) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        tabBarItems.forEach { tabBarItem ->
            BottomNavigationItem(
                modifier = tabBarItem.padding,
                selected = currentRoute == tabBarItem.routes,
                onClick = {
                    navController.navigate(tabBarItem.routes) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = {
                    TabBarIconView(
                        isSelected = currentRoute == tabBarItem.routes,
                        selectedIcon = tabBarItem.selectedIcon,
                        unselectedIcon = tabBarItem.unselectedIcon,

                        )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
//                modifier = Modifier
//                    .padding(horizontal = 8.dp, vertical = 8.dp)
//                    .size(40.dp)
            )
        }
    }
}




@Composable
fun TabBarIconView(
    isSelected: Boolean,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    badgeAmount: Int? = null
) {
    BadgedBox(badge = { TabBarBadgeView(badgeAmount) }) {
        Icon(
            imageVector = if (isSelected) selectedIcon else unselectedIcon,
            contentDescription = null,
            tint = if (isSelected) Color.Black else Color.Gray,
            modifier = Modifier.size(30.dp)  // Adjust icon size if needed
        )
    }
}



@Composable
fun TabBarBadgeView(count : Int? = null){
    if(count != null){
        Badge{
            Text(count.toString())
        }
    }
}
