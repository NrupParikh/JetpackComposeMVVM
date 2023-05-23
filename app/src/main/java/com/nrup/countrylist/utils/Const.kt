package com.nrup.countrylist.utils

object Const{
    const val BASE_URL = "https://restcountries.com"

    //https://restcountries.com/v2/all
    const val METHOD_ALL_COUNTRY = "/v2/all"

    //https://restcountries.com/v2/alpha/IND
    const val METHOD_COUNTRY_DETAILS = "/v2/alpha/{countryCode}"
    const val ARG_COUNTRY_CODE = "countryCode"
    const val ARG_COUNTRY_NAME = "countryName"

    // SCREEN PARAMETERS
    const val HOME_SCREEN = "home"

    const val DETAIL_SCREEN  = "detail"
    const val DETAIL_ARG_COUNTRY_ID = "alpha2Code"

    const val FAVORITE_SCREEN = "favorite"
    const val SETTINGS_SCREEN = "settings"


}