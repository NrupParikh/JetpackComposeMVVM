package com.nrup.countrylist.ui.fragment.place

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.nrup.countrylist.ui.fragment.contactus.screen.ContactUsScreen
import com.nrup.countrylist.ui.theme.CountryListTheme
import com.nrup.countrylist.viewmodel.PlaceViewModel

@Composable
fun PlaceFragment(
    placeViewModel: PlaceViewModel = hiltViewModel()
) {
    ContactUsScreen()
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AboutUsFragmentPreview() {
    CountryListTheme {
        PlaceFragment()
    }
}