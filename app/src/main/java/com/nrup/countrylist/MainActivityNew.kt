package com.nrup.countrylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.nrup.countrylist.ui.components.navgraph.RootNavigationGraph
import com.nrup.countrylist.ui.theme.CountryListTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivityNew : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryListTheme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}

