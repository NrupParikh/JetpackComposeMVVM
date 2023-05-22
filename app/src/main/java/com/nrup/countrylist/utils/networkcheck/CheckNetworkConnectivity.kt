package com.nrup.countrylist.utils.networkcheck

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

//  function to check internet connectivity

@Composable
fun checkInternetConnectivity(): Boolean {

    val context = LocalContext.current
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val networkCapabilities =
        connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
}