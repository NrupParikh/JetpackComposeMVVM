package com.nrup.countrylist.utils

class AppUtils {
    companion object {

        // Extension Function

        fun String.getValue(): String {
            return when (this) {
                "null" -> "N/A"
                else -> this
            }
        }
    }
}