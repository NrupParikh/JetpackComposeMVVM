package com.nrup.countrylist.utils

import com.nrup.countrylist.utils.Const.FAVORITE_SCREEN
import com.nrup.countrylist.utils.Const.HOME_SCREEN
import com.nrup.countrylist.utils.Const.SETTINGS_SCREEN

sealed class Route(val route: String) {
    object Home : Route(HOME_SCREEN)
    object Favourite : Route(FAVORITE_SCREEN)
    object Settings : Route(SETTINGS_SCREEN)
}
