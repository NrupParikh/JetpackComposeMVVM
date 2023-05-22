package com.nrup.countrylist.utils.networkcheck

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

// Listen for network changes and update your UI accordingly.

@Composable
fun networkStatusListener(): MutableState<Boolean> {
    val context = LocalContext.current
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val rememberNetworkStatus = remember { mutableStateOf(false) }


    val networkCallback = remember {
        object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                // Network is available
                Log.d("TAG", "INTERNET : onAvailable")
                rememberNetworkStatus.value = true
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                // Network is lost
                Log.d("TAG", "INTERNET : lost")
                rememberNetworkStatus.value = false
            }
        }
    }

    // Register and un-register connectivity manager

    DisposableEffect(connectivityManager) {
        connectivityManager.registerDefaultNetworkCallback(networkCallback)

        onDispose {
            connectivityManager.unregisterNetworkCallback(networkCallback)
        }
    }

    return rememberNetworkStatus
}