package com.nrup.countrylist.ui.fragment.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.nrup.countrylist.ui.components.CustomProgressBar
import com.nrup.countrylist.ui.fragment.screen.CountryListUI
import com.nrup.countrylist.utils.Response
import com.nrup.countrylist.viewmodel.HomeViewModel

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    fun launch() {
        homeViewModel.getCountryList()
    }

    launch()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (val countryResponse = homeViewModel.countryListState.value) {
            is Response.Loading -> {
                CustomProgressBar(
                    modifier = Modifier.fillMaxWidth()
                )
            }

            is Response.Success -> {

                CountryListUI(countryResponse.data)
            }

            is Response.Failure -> {

            }
        }

    }
}
