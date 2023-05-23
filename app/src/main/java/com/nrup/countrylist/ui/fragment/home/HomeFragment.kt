package com.nrup.countrylist.ui.fragment.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.nrup.countrylist.R
import com.nrup.countrylist.ui.components.ErrorButton
import com.nrup.countrylist.ui.fragment.home.screen.HomeScreen
import com.nrup.countrylist.ui.theme.CountryListTheme
import com.nrup.countrylist.utils.Response
import com.nrup.countrylist.utils.networkcheck.NoConnectivityException
import com.nrup.countrylist.utils.networkcheck.NoInternetConnectivity
import com.nrup.countrylist.utils.shimmer.ListItemShimmerEffect
import com.nrup.countrylist.viewmodel.HomeViewModel

@Composable
fun HomeFragment(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onClickToDetailScreen: (Triple<Int, String, String>) -> Unit = {},
) {
//    val context = LocalContext.current
//    val isInternetConnected = checkInternetConnectivity()
//    val isOnline by remember { mutableStateOf(isInternetConnected) }

    // For swipe to refresh
    val isLoading by homeViewModel.isLoading.collectAsState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isLoading)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        when (val countryResponse = homeViewModel.countryListState.value) {
            is Response.Loading -> {
                /*
                // As we are showing shimmer loading effect, this code is commented
                CustomProgressBar(
                     modifier = Modifier.fillMaxWidth()
                 )*/

                Column {
                    repeat(7) {
                        ListItemShimmerEffect()
                    }
                }
            }

            is Response.Success -> {
                SwipeRefresh(state = swipeRefreshState, onRefresh = {
                    homeViewModel.getCountryList()
                }) {
                    HomeScreen(
                        countryResponse.data, onClickToDetailScreen = onClickToDetailScreen
                    )
                }

            }

            is Response.Failure -> {
                val exception = countryResponse.e
                if (exception is NoConnectivityException) {
                    exception.localizedMessage?.let {
                        NoInternetConnectivity(
                            onRetryClick = { homeViewModel.getCountryList() })
                    }
                } else {
                    ErrorButton(modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.error),
                        onClick = {
                            homeViewModel.getCountryList()
                        })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeFragmentPreview() {
    CountryListTheme {
        HomeFragment()
    }
}