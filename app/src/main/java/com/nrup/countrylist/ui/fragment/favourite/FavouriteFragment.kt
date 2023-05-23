package com.nrup.countrylist.ui.fragment.favourite

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.nrup.countrylist.ui.fragment.favourite.screen.FavouriteScreen
import com.nrup.countrylist.ui.theme.CountryListTheme
import com.nrup.countrylist.viewmodel.FavouriteViewModel

@Composable
fun FavouriteFragment(
    favouriteViewModel: FavouriteViewModel = hiltViewModel()
) {
    FavouriteScreen()
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailsFragmentPreview() {
    CountryListTheme {
        FavouriteFragment()
    }
}