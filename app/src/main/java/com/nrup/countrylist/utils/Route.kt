package com.nrup.countrylist.utils

import com.nrup.countrylist.utils.Const.ROUTE_FAVOURITE
import com.nrup.countrylist.utils.Const.ROUTE_HOME
import com.nrup.countrylist.utils.Const.ROUTE_SETTINGS

sealed class Route(val route: String) {
    object Home : Route(ROUTE_HOME)
    object Favourite : Route(ROUTE_FAVOURITE)
    object Settings : Route(ROUTE_SETTINGS)
}
