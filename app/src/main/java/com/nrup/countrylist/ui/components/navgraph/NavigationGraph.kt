package com.nrup.countrylist.ui.components.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.nrup.countrylist.ui.fragment.detail.DetailsFragment
import com.nrup.countrylist.ui.fragment.favourite.FavouriteFragment
import com.nrup.countrylist.ui.fragment.home.HomeFragment
import com.nrup.countrylist.ui.fragment.settings.SettingsFragment
import com.nrup.countrylist.utils.Const.ARG_COUNTRY_CODE
import com.nrup.countrylist.utils.Const.ARG_COUNTRY_NAME
import com.nrup.countrylist.utils.Const.ROUTE_DETAIL
import com.nrup.countrylist.utils.Route

@Composable
fun NavigationGraph(navController: NavHostController, title: MutableState<String>) {
    NavHost(
        navController = navController,
        startDestination = Route.Home.route
    ) {

        // Home Screen
        composable(route = Route.Home.route) {
            HomeFragment() {
                navController.navigate(route = "$ROUTE_DETAIL/${it.second}/${it.third}")
            }
        }

        // Home Details Screen
        composable(route = "$ROUTE_DETAIL/{$ARG_COUNTRY_CODE}/{$ARG_COUNTRY_NAME}",
            arguments = listOf(
                navArgument(ARG_COUNTRY_CODE) {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument(ARG_COUNTRY_NAME) {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            DetailsFragment(appTitle = title)
        }

        // Favourite Screen
        composable(route = Route.Favourite.route) {
            FavouriteFragment()
        }

        // Settings Screen
        composable(route = Route.Settings.route) {
            SettingsFragment()
        }
    }
}