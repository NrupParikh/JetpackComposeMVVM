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
import com.nrup.countrylist.utils.Const.ARG_COUNTRY_NAME
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
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.Home.route
    ) {

        composable(route = Route.Home.route) {
            HomeFragment {
                navController.navigate(route = "$DETAIL_SCREEN/${it.second}/${it.third}")
            }
        }

        composable(route = "$DETAIL_SCREEN/{$ARG_COUNTRY_CODE}/{$ARG_COUNTRY_NAME}",
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
            DetailsFragment()
        }
    }
}

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

