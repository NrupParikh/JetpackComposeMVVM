package com.nrup.countrylist.ui.fragment.detail

import android.content.res.Configuration
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
import com.nrup.countrylist.ui.fragment.detail.screen.DetailsScreen
import com.nrup.countrylist.ui.theme.CountryListTheme
import com.nrup.countrylist.utils.Response
import com.nrup.countrylist.utils.shimmer.DetailScreenShimmerEffect
import com.nrup.countrylist.viewmodel.DetailsViewModel

@Composable
fun DetailsFragment(
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {

    // For swipe to refresh
    val isLoading by detailsViewModel.isLoading.collectAsState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isLoading)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        when (val countryDataResponse = detailsViewModel.countryDetailsState.value) {
            is Response.Loading -> {
//                CustomProgressBar(
//                    modifier = Modifier.fillMaxWidth()
//                )

                DetailScreenShimmerEffect()
            }

            is Response.Success -> {

                SwipeRefresh(state = swipeRefreshState, onRefresh = {
                    detailsViewModel.getCountryDetails()
                }) {
                    DetailsScreen(countryData = countryDataResponse.data)
                }
            }

            is Response.Failure -> {
                ErrorButton(modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.error),
                    onClick = {
                        detailsViewModel.getCountryDetails()
                    })
            }
        }
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailsFragmentPreview() {
    CountryListTheme {
        DetailsFragment()
    }
}