package com.nrup.countrylist.ui.fragment.aboutUs

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.nrup.countrylist.ui.fragment.aboutUs.screen.AboutUsScreen
import com.nrup.countrylist.ui.theme.CountryListTheme
import com.nrup.countrylist.viewmodel.AboutUsViewModel

@Composable
fun AboutUsFragment(
    aboutUsViewModel: AboutUsViewModel = hiltViewModel()
) {
    AboutUsScreen()
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AboutUsFragmentPreview() {
    CountryListTheme {
        AboutUsFragment()
    }
}