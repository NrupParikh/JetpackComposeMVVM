package com.nrup.countrylist.utils.networkcheck

import java.io.IOException


class NoConnectivityException : IOException() {
    override fun getLocalizedMessage(): String? {
        return "No Internet connection."
    }
}