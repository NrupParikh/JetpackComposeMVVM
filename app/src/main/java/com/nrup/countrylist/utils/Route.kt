package com.nrup.countrylist.utils

import com.nrup.countrylist.utils.Const.HOME_SCREEN

sealed class Route(val route: String) {
    object Home : Route(HOME_SCREEN)
}
