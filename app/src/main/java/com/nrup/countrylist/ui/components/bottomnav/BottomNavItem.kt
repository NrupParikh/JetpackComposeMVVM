package com.nrup.countrylist.ui.components.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.nrup.countrylist.utils.Const.TITLE_FAVOURITE_SCREEN
import com.nrup.countrylist.utils.Const.TITLE_HOME_SCREEN
import com.nrup.countrylist.utils.Const.ROUTE_FAVOURITE
import com.nrup.countrylist.utils.Const.ROUTE_HOME
import com.nrup.countrylist.utils.Const.ROUTE_SETTINGS
import com.nrup.countrylist.utils.Const.TITLE_SETTINGS_SCREEN

sealed class BottomNavItem(var title: String, var icon: ImageVector, var screen_route: String) {

    object Home :
        BottomNavItem(
            title = TITLE_HOME_SCREEN,
            icon = Icons.Rounded.Home,
            screen_route = ROUTE_HOME
        )

    object Favorite :
        BottomNavItem(
            title = TITLE_FAVOURITE_SCREEN,
            icon = Icons.Rounded.Favorite,
            screen_route = ROUTE_FAVOURITE
        )

    object Settings :
        BottomNavItem(
            title = TITLE_SETTINGS_SCREEN,
            icon = Icons.Rounded.Settings,
            screen_route = ROUTE_SETTINGS
        )
}