package com.nrup.countrylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nrup.countrylist.ui.fragment.home.HomeFragment
import com.nrup.countrylist.ui.theme.CountryListTheme
import com.nrup.countrylist.utils.Route
import dagger.hilt.android.AndroidEntryPoint

// Single Activity per app

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryListTheme {
                // A surface container using the 'background' color from the theme
                CountryListScreen()
            }
        }
    }
}

@Composable
fun CountryListScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.Home.route
    ) {

        composable(route = Route.Home.route) {
            HomeFragment()
        }
    }
}


