package com.nrup.countrylist.utils.networkcheck

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(myContext: Context) : Interceptor {

    private val context = myContext

    override fun intercept(chain: Interceptor.Chain): Response {

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        val isInternetConnected =
            networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false

        Log.d("TAG", "MainActivity $isInternetConnected")
        if (!isInternetConnected) {
            throw NoConnectivityException()
        }
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

}