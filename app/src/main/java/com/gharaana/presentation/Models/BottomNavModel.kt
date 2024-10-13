package com.gharaana.presentation.Models

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp

data class BottomNavModel(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val routes : String,
    val padding : Modifier
)
