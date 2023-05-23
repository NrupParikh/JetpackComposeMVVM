package com.nrup.countrylist.ui.components.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(var title: String, var icon: ImageVector, var screen_route: String) {
    object Home : BottomNavItem("Home", Icons.Rounded.Home, "home")
    object Favorite : BottomNavItem("Favorite", Icons.Rounded.Favorite, "favorite")
    object Settings : BottomNavItem("Settings", Icons.Rounded.Settings, "settings")
}