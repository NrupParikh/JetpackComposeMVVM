package com.nrup.countrylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nrup.countrylist.ui.components.bottomnav.BottomNavItem
import com.nrup.countrylist.ui.components.bottomnav.MyBottomNavigation
import com.nrup.countrylist.ui.components.navgraph.NavigationGraph
import com.nrup.countrylist.ui.components.topbar.MyTopAppBar
import com.nrup.countrylist.ui.theme.CountryListTheme
import dagger.hilt.android.AndroidEntryPoint


// Single Activity per app

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryListTheme {

                //https://medium.com/geekculture/bottom-navigation-in-jetpack-compose-android-9cd232a8b16

                val navController = rememberNavController()
                val backStackEntry = navController.currentBackStackEntryAsState()

                val items = listOf(
                    BottomNavItem.Home,
                    BottomNavItem.Favorite,
                    BottomNavItem.Settings
                )

                Scaffold(
                    topBar = {
                        MyTopAppBar()
                    }, content = { padding ->
                        // This padding not overlap the content to TopBar and BottomBar
                        Box(
                            modifier = Modifier.padding(padding)
                        ) {
                            NavigationGraph(navController = navController)
                        }
                    },
                    bottomBar = {
                        MyBottomNavigation(
                            navController = navController,
                            bottomNavigationItems = items,
                            backStackEntry
                        )
                    }
                )
            }
        }
    }
}

//@Composable
//fun MainScreen(padding: PaddingValues) {
//    val navController = rememberNavController()
//    NavHost(
//        navController = navController,
//        startDestination = Route.Home.route
//    ) {
//
//        composable(route = Route.Home.route) {
//            HomeFragment {
//                navController.navigate(route = "$DETAIL_SCREEN/${it.second}/${it.third}")
//            }
//        }
//
//        composable(route = "$DETAIL_SCREEN/{$ARG_COUNTRY_CODE}/{$ARG_COUNTRY_NAME}",
//            arguments = listOf(
//                navArgument(ARG_COUNTRY_CODE) {
//                    type = NavType.StringType
//                    defaultValue = ""
//                },
//                navArgument(ARG_COUNTRY_NAME) {
//                    type = NavType.StringType
//                    defaultValue = ""
//                }
//            )
//        ) {
//            DetailsFragment()
//        }
//    }
//}

// =================== with network check


//@Composable
//fun MainScreen() {
//
//    // Register the NetworkCallback
//
//    val status = networkStatusListener()
//
//    // val isInternetConnected = checkInternetConnectivity()
//    // Log.d("TAG", "MainActivity isInternetConnected $isInternetConnected")
//
//    if (!status.value) {
////        NoInternetConnectivity()
//
//        var showCustomOkCancelDialogWithResult by remember { mutableStateOf(true) }
//        Log.d(
//            "TAG",
//            "MainActivity showCustomOkCancelDialogWithResult $showCustomOkCancelDialogWithResult"
//        )
//
//        if (showCustomOkCancelDialogWithResult) {
//            CustomOkCancelDialog(
//                message = stringResource(id = R.string.no_internet_connection),
//                hasNegativeButton = false,
//                onDismiss = {
//                    showCustomOkCancelDialogWithResult = !showCustomOkCancelDialogWithResult
//                },
//                onNegativeClick = {
//                    //showCustomOkCancelDialogWithResult = !showCustomOkCancelDialogWithResult
//                },
//                onPositiveClick = {
//                    showCustomOkCancelDialogWithResult = !showCustomOkCancelDialogWithResult
//                }
//            )
//        }
//
//    } else {
//        val navController = rememberNavController()
//        NavHost(
//            navController = navController,
//            startDestination = Route.Home.route
//        ) {
//
//            composable(route = Route.Home.route) {
//                HomeFragment {
//                    navController.navigate(route = "$DETAIL_SCREEN/${it.second}/${it.third}")
//                }
//            }
//
//            composable(route = "$DETAIL_SCREEN/{$ARG_COUNTRY_CODE}/{$ARG_COUNTRY_NAME}",
//                arguments = listOf(
//                    navArgument(ARG_COUNTRY_CODE) {
//                        type = NavType.StringType
//                        defaultValue = ""
//                    },
//                    navArgument(ARG_COUNTRY_NAME) {
//                        type = NavType.StringType
//                        defaultValue = ""
//                    }
//                )
//            ) {
//                DetailsFragment()
//            }
//        }
//    }
//
//}

