package com.nrup.countrylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nrup.countrylist.ui.fragment.detail.DetailsFragment
import com.nrup.countrylist.ui.fragment.home.HomeFragment
import com.nrup.countrylist.ui.theme.CountryListTheme
import com.nrup.countrylist.utils.Const.ARG_COUNTRY_CODE
import com.nrup.countrylist.utils.Const.DETAIL_SCREEN
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
            HomeFragment {
                navController.navigate(route = "$DETAIL_SCREEN/${it.second}")
            }
        }

        composable(route = "$DETAIL_SCREEN/{$ARG_COUNTRY_CODE}",
            arguments = listOf(
                navArgument(ARG_COUNTRY_CODE) {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            DetailsFragment()
        }
    }
}


