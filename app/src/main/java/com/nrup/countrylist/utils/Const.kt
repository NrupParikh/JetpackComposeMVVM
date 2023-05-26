package com.nrup.countrylist.utils

object Const{
    const val BASE_URL = "https://restcountries.com"

    //https://restcountries.com/v2/all
    const val METHOD_ALL_COUNTRY = "/v2/all"

    //https://restcountries.com/v2/alpha/IND
    const val METHOD_COUNTRY_DETAILS = "/v2/alpha/{countryCode}"
    const val ARG_COUNTRY_CODE = "countryCode"
    const val ARG_COUNTRY_NAME = "countryName"

    // ROUTE
    const val ROUTE_HOME = "home"
    const val ROUTE_DETAIL  = "detail"
    const val ROUTE_FAVOURITE = "favorite"
    const val ROUTE_SETTINGS = "settings"

    // Screen Name
    const val TITLE_HOME_SCREEN = "Home"
    const val TITLE_FAVOURITE_SCREEN = "Favorite"
    const val TITLE_SETTINGS_SCREEN = "Settings"
    const val TITLE_DETAIL_SCREEN = "Details"

}