package com.nrup.countrylist.ui.components.drawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Place
import androidx.compose.ui.graphics.vector.ImageVector
import com.nrup.countrylist.utils.Const.ROUTE_ABOUT_US
import com.nrup.countrylist.utils.Const.ROUTE_CONTACT_US
import com.nrup.countrylist.utils.Const.ROUTE_HOME
import com.nrup.countrylist.utils.Const.ROUTE_PLACE
import com.nrup.countrylist.utils.Const.TITLE_ABOUT_US_SCREEN
import com.nrup.countrylist.utils.Const.TITLE_CONTACT_US_SCREEN
import com.nrup.countrylist.utils.Const.TITLE_HOME_SCREEN
import com.nrup.countrylist.utils.Const.TITLE_PLACE_SCREEN

sealed class DrawerItem(var title: String, var icon: ImageVector, var screen_route: String) {

    object Place :
        DrawerItem(
            title = TITLE_PLACE_SCREEN,
            icon = Icons.Rounded.Place,
            screen_route = ROUTE_PLACE
        )

    object ContactUs :
        DrawerItem(
            title = TITLE_CONTACT_US_SCREEN,
            icon = Icons.Rounded.Call,
            screen_route = ROUTE_CONTACT_US
        )

    object AboutUs :
        DrawerItem(
            title = TITLE_ABOUT_US_SCREEN,
            icon = Icons.Rounded.Info,
            screen_route = ROUTE_ABOUT_US
        )
}